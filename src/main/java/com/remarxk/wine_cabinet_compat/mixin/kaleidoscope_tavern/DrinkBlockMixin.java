package com.remarxk.wine_cabinet_compat.mixin.kaleidoscope_tavern;

import com.github.ysbbbbbb.kaleidoscopetavern.block.brew.DrinkBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.satisfy.vinery.core.block.WineBottleBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DrinkBlock.class)
public class DrinkBlockMixin {
    @Redirect(
            method = "createCountBlockStateDefinition",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/StateDefinition$Builder;add([Lnet/minecraft/world/level/block/state/properties/Property;)Lnet/minecraft/world/level/block/state/StateDefinition$Builder;")
    )
    private StateDefinition.Builder<Block, BlockState> addFakeModelState(StateDefinition.Builder instance, Property<?>[] properties) {
        Property<?>[] newProperties = new Property[properties.length + 1];

        System.arraycopy(properties, 0, newProperties, 0, properties.length);

        newProperties[newProperties.length - 1] = WineBottleBlock.FAKE_MODEL;
        return instance.add(newProperties);
    }
}
