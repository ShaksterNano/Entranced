package io.github.shaksternano.entranced.mixin.fabric.commonside.retainenchantment.item;

import io.github.shaksternano.entranced.commonside.util.EnchantmentUtil;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemDispenserBehavior.class)
abstract class ItemDispenserBehaviorMixin {

    /*
    Buckets retain their enchantments when used in a dispenser.
    Forge equivalent is io.github.shaksternano.entranced.mixin.forge.commonside.retainenchantment.item.ItemDispenserBehaviorMixin#dispenserTransferEnchantments
     */
    @Inject(method = "dispense", at = @At("RETURN"))
    private void dispenserTransferEnchantments(BlockPointer blockPointer, ItemStack itemStack, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack itemStack2 = cir.getReturnValue();
        EnchantmentUtil.copyEnchantments(itemStack, itemStack2);
    }
}