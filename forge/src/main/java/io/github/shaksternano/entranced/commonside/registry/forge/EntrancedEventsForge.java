package io.github.shaksternano.entranced.commonside.registry.forge;

import io.github.shaksternano.entranced.commonside.event.enchantment.forge.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;

public final class EntrancedEventsForge {

    private EntrancedEventsForge() {}

    public static void registerServerEvents() {
        IEventBus eventBus = MinecraftForge.EVENT_BUS;

        eventBus.register(FrenzyEventsForge.class);
        eventBus.register(ImperishableEventsForge.class);
    }
}