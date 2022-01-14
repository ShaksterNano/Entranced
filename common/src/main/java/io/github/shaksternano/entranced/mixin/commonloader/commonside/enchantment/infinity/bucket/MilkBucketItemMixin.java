package io.github.shaksternano.entranced.mixin.commonloader.commonside.enchantment.infinity.bucket;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import io.github.shaksternano.entranced.commonside.util.EnchantmentUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MilkBucketItem;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@SuppressWarnings("unused")
@Mixin(MilkBucketItem.class)
abstract class MilkBucketItemMixin {

    // A milk bucket ItemStack with the Infinity enchantment doesn't have its count decremented.
    @ModifyExpressionValue(method = "finishUsing", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/player/PlayerAbilities;creativeMode:Z", opcode = Opcodes.GETFIELD))
    private boolean entranced$infinityNoDecrement(boolean creativeMode, ItemStack stack) {
        return creativeMode || EnchantmentUtil.isBucketAndHasInfinityAndBucketEnabled(stack);
    }
}
