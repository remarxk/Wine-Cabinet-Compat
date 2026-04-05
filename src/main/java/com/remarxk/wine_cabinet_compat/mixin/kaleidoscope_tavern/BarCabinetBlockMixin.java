package com.remarxk.wine_cabinet_compat.mixin.kaleidoscope_tavern;

import com.github.ysbbbbbb.kaleidoscopetavern.block.brew.BarCabinetBlock;
import com.github.ysbbbbbb.kaleidoscopetavern.block.brew.BottleBlock;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks;
import com.remarxk.wine_cabinet_compat.util.TagUtil;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BarCabinetBlock.class)
public abstract class BarCabinetBlockMixin {

    @Inject(method = "getBottleBlock", at = @At("HEAD"), cancellable = true, remap = false)
    private void kc$getVineryBottleBlock(ItemStack stack, CallbackInfoReturnable<BottleBlock> cir) {
        if (stack.is(TagUtil.Items.BOTTLE_ITEMS)) {
            cir.setReturnValue((BottleBlock) ModBlocks.EMPTY_BOTTLE.get());
        }
        else if (stack.is(TagUtil.Items.IRREGULAR_BOTTLE)) {
            cir.setReturnValue((BottleBlock) ModBlocks.BRANDY.get());
        }
    }
}
