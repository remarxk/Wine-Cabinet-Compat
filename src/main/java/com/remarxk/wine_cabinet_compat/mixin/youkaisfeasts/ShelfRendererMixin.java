package com.remarxk.wine_cabinet_compat.mixin.youkaisfeasts;

import dev.xkmc.youkaishomecoming.content.pot.storage.shelf.ShelfRenderer;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.level.block.state.BlockState;
import net.satisfy.vinery.core.block.WineBottleBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ShelfRenderer.class)
public class ShelfRendererMixin {
    @Redirect(
            method = "render(Ldev/xkmc/youkaishomecoming/content/pot/storage/shelf/WineShelfBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/block/BlockModelShaper;getBlockModel(Lnet/minecraft/world/level/block/state/BlockState;)Lnet/minecraft/client/resources/model/BakedModel;"
            )
    )
    private BakedModel setFakeModelState(BlockModelShaper instance, BlockState state) {
        var newState = state.trySetValue(WineBottleBlock.FAKE_MODEL, false);
        return instance.getBlockModel(newState);
    }
}
