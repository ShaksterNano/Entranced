package io.github.shaksternano.entranced.mixin.commonloader.commonside.accessor;

import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(DimensionType.class)
public interface DimensionTypeAccessor {

    @Accessor("OVERWORLD")
    static DimensionType entranced$getOverworld() {
        throw new AssertionError();
    }
}
