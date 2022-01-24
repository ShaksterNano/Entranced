package io.github.shaksternano.entranced.commonside.eventhook.enchantment.forge;

import io.github.shaksternano.entranced.commonside.config.ImperishableBlacklists;
import io.github.shaksternano.entranced.commonside.enchantment.ImperishableEnchantment;
import io.github.shaksternano.entranced.commonside.registry.EntrancedEnchantments;
import io.github.shaksternano.entranced.commonside.util.EnchantmentUtil;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class ImperishableEventHooksForge {

    private ImperishableEventHooksForge() {}

    /**
     * Item entities with the {@link ImperishableEnchantment} don't despawn.
     * Fabric equivalent is io.github.shaksternano.entranced.mixin.fabric.commonside.enchantment.imperishable.ItemEntityMixin#imperishableNoItemDespawn
     */
    @SubscribeEvent
    public static void imperishableNoItemDespawn(ItemExpireEvent event) {
        ItemStack stack = event.getEntityItem().getStack();
        if (EnchantmentUtil.hasEnchantment(stack, EntrancedEnchantments.IMPERISHABLE)) {
            if (ImperishableBlacklists.isItemProtected(stack, ImperishableBlacklists.ProtectionType.DESPAWN_PROTECTION)) {
                event.setExtraLife(0);
            }
        }
    }
}