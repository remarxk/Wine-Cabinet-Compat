package com.remarxk.wine_cabinet_compat.mixin.kaleidoscope_tavern;

import com.github.ysbbbbbb.kaleidoscopetavern.client.render.block.BarCabinetBlockEntityRender;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.satisfy.vinery.core.block.WineBottleBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BarCabinetBlockEntityRender.class)
public abstract class BarCabinetBlockEntityRenderMixin {
    @Redirect(
            method = "render*",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/Block;defaultBlockState()Lnet/minecraft/world/level/block/state/BlockState;"
            )
    )
    private BlockState kc$modifyVineryBlockState(Block instance) {
        return kc$modifyBlockState(instance);
    }

    @Unique
    private BlockState kc$modifyBlockState(Block instance) {
        BlockState state = instance.defaultBlockState();
        return state.trySetValue(WineBottleBlock.FAKE_MODEL, false);
    }
}