package io.github.shaksternano.entranced.commonside.access.enchantingtablefilter;

import io.github.shaksternano.entranced.commonside.config.EnchantingCatalystConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public interface PlayerEntityAccess {

    Optional<EnchantingCatalystConfig.EnchantingCatalystType> entranced$getEnchantingCatalystType();

    void entranced$setEnchantingCatalystType(@Nullable EnchantingCatalystConfig.EnchantingCatalystType catalystType);

    void entranced$setNewEnchantingTableSeed();
}
