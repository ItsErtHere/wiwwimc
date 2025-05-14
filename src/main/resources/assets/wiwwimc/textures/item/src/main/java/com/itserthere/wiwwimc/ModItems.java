package com.itserthere.wiwwimc;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import static com.itserthere.wiwwimc.ModBlocks.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(WIWWIMC.MODID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    public static DeferredItem<Item> registerItem(String name) {
        return ITEMS.registerSimpleItem(name,
                new Item.Properties().setId(ResourceKey.create(Registries.ITEM,
                        ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,name))));
    }
    public static DeferredItem<Item> registerDyeableItem(String name) {
        return ITEMS.registerSimpleItem(name,
                new Item.Properties().setId(ResourceKey.create(Registries.ITEM,
                        ResourceLocation.fromNamespaceAndPath(WIWWIMC.MODID,name))));
    }
    public static final DeferredItem<Item> WOODEN_CHUNK = registerItem("wooden_chunk");
    public static final DeferredItem<BlockItem> IRON_TILE_ITEM = ModBlocks.registerBI("iron_tile", IRON_TILE);
}
