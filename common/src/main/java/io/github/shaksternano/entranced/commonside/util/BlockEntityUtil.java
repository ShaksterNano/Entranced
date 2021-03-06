package io.github.shaksternano.entranced.commonside.util;

import io.github.shaksternano.entranced.commonside.access.retainenchantment.block.EnchantmentHolder;
import io.github.shaksternano.entranced.mixin.commonloader.commonside.accessor.ItemStackAccessor;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;

public class BlockEntityUtil {

    /**
     * Copies the enchantments and repair cost of an {@link ItemStack} to a {@link BlockEntity}.
     */
    @SuppressWarnings("ConstantConditions")
    public static void setBlockEntityEnchantments(BlockEntity blockEntity, ItemStack stack) {
        EnchantmentHolder enchantmentHolder = (EnchantmentHolder) blockEntity;

        if (stack.hasEnchantments()) {
            enchantmentHolder.entranced$setEnchantments(stack.getEnchantments());
        }

        if (stack.hasNbt()) {
            if (stack.getNbt().contains(ItemStackAccessor.entranced$getRepairCostKey(), 3)) {
                enchantmentHolder.entranced$setRepairCost(stack.getRepairCost());
            }
        }
    }

    /**
     * Copies the enchantments and repair cost of a {@link BlockEntity} to an {@link ItemStack}.
     */
    public static void setDroppedItemStackEnchantments(BlockEntity blockEntity, ItemStack stack) {
        EnchantmentHolder enchantmentHolder = (EnchantmentHolder) blockEntity;

        enchantmentHolder.entranced$getEnchantments().ifPresent(enchantmentsNbt -> stack.setSubNbt(ItemStack.ENCHANTMENTS_KEY, enchantmentsNbt));
        enchantmentHolder.entranced$getRepairCost().ifPresent(stack::setRepairCost);

    }
}
