package io.github.shaksternano.entranced.commonside.fabricasm.fabric;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;

public class EntrancedFabricEarlyRiser implements Runnable {

    @Override
    public void run() {
        MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
        String enchantmentTarget = remapper.mapClassName("intermediary", "net.minecraft.class_1886");

        addEnumSubclass(
                enchantmentTarget,
                EntrancedEnchantmentTarget.IMPERISHABLE,
                EnchantmentTargets.class.getName() + "$ImperishableTarget"
        );

        addEnumSubclass(
                enchantmentTarget,
                EntrancedEnchantmentTarget.FLUID_CONTAINER,
                EnchantmentTargets.class.getName() + "$FluidContainerTarget"
        );
    }

    private static void addEnumSubclass(String mappedClassName, CustomEnum customEnum, String structClass) {
        ClassTinkerers.enumBuilder(mappedClassName).addEnumSubclass(customEnum.getName(), structClass).build();
    }
}
