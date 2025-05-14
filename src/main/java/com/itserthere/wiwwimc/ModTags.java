package com.itserthere.wiwwimc;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,name));
        }
        //  --  BLOCK TAGS --
        public static final TagKey<Block> IS_LEATHER_DYEABLE = createTag("is_leather_dyeable");
        public static final TagKey<Block> PS_LEATHER_DYEABLE = createTag("ps_leather_dyeable");
        // --  END BLOCKS --
    }
    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,name));
        }
        //  --  ITEM TAGS  --
        //public static final TagKey<Item> EXAMPLE_TAG = createTag("example_tag");
        //  --  END ITEMS  --
    }
}
