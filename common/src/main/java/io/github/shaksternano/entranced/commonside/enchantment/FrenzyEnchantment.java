package io.github.shaksternano.entranced.commonside.enchantment;

import io.github.shaksternano.entranced.commonside.Entranced;
import io.github.shaksternano.entranced.commonside.registry.EntrancedEnchantments;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

/**
 * Increases the attack speed of weapons.
 */
public class FrenzyEnchantment extends ConfigurableEnchantment {

    public FrenzyEnchantment() {
        super(Entranced.getConfig().getFrenzyRarity(), EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND);
    }

    public static double getAttackSpeed(ItemStack stack, double baseAttackSpeed) {
        return Entranced.getConfig().getFrenzyExtraAttackSpeedPerLevel() * EnchantmentHelper.getLevel(EntrancedEnchantments.FRENZY, stack) + baseAttackSpeed;
    }

    @Override
    public int getMaxLevel() {
        return Entranced.getConfig().getFrenzyMaxLevel();
    }

    @Override
    public boolean isTreasure() {
        return Entranced.getConfig().isFrenzyTreasure();
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return Entranced.getConfig().isFrenzySoldByVillagers();
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        boolean damageMutuallyExclusive = Entranced.getConfig().isFrenzyMutuallyExclusiveWithDamageEnchantments() && other instanceof DamageEnchantment;
        return !damageMutuallyExclusive && super.canAccept(other);
    }

    @Override
    public boolean isEnabled() {
        return Entranced.getConfig().isFrenzyEnabled();
    }

    @Override
    protected int minPower() {
        return Entranced.getConfig().getFrenzyMinPower();
    }

    @Override
    protected int maxPowerAboveMin() {
        return Entranced.getConfig().getFrenzyMaxPowerAboveMin();
    }

    @Override
    public String getPath() {
        return "frenzy";
    }
}
