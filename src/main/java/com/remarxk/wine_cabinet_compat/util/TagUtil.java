package com.remarxk.wine_cabinet_compat.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagUtil {
    public static class Items {
        /**
         * 正常瓶子的酒
         * 用于标记那些可以被放入森罗酒柜的方块
         */
        public static final TagKey<Item> BOTTLE_ITEMS =
                TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("kaleidoscope_tavern", "bottle_items"));

        /**
         * 正常瓶子的酒
         * 用于标记那些可以被放入森罗酒柜的方块
         */
        public static final TagKey<Item> IRREGULAR_BOTTLE =
                TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("kaleidoscope_tavern", "irregular_bottle"));

        /**
         * 幻想乡的酒柜
         * 用于标记那些可以被放入幻想乡酒柜的方块
         */
        public static final TagKey<Item> WINE =
                TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("youkaisfeasts", "wine"));
    }
}