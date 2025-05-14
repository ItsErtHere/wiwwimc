package com.itserthere.wiwwimc;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.itserthere.wiwwimc.WIWWIMC.BLOCKS;
import static com.itserthere.wiwwimc.WIWWIMC.ITEMS;

public class ModBlocks {
    //ICE FRICTION: 0.98
    //  --  FUNCTIONS  --
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(WIWWIMC.MODID);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static DeferredBlock<Block> registerMetalBlock(String name, MapColor mapColor, SoundType sound) {
        return BLOCKS.register(
                name, registryName -> new Block(BlockBehaviour.Properties.of()
                        .setId(ResourceKey.create(Registries.BLOCK, registryName))
                        .mapColor(mapColor).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                        .requiresCorrectToolForDrops().strength(0.3F, 6.0F)
                        .sound(sound)
                ));
    }
    //NOT FOR CHERRY, BAMBOO, OR NETHER WOOD
    public static DeferredBlock<Block> registerWoodenBlock(String name, MapColor mapColor) {
        return BLOCKS.register(
                name, registryName -> new Block(BlockBehaviour.Properties.of()
                        .setId(ResourceKey.create(Registries.BLOCK, registryName))
                        .mapColor(mapColor).instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()
                ));
    }
    public static DeferredBlock<Block> registerStoneBlock(String name) {
        return BLOCKS.register(
                name, registryName -> new Block(BlockBehaviour.Properties.of()
                        .setId(ResourceKey.create(Registries.BLOCK, registryName))
                        .mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                        .strength(2.0F, 6.0F).sound(SoundType.STONE)
                ));
    }
    //For other wood types
    public static DeferredBlock<Block> registerWoodenBlock(String name, MapColor mapColor, SoundType soundType) {
        return BLOCKS.register(
                name, registryName -> new Block(BlockBehaviour.Properties.of()
                        .setId(ResourceKey.create(Registries.BLOCK, registryName))
                        .mapColor(mapColor).instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F, 3.0F).sound(soundType).ignitedByLava()
                ));
    }
    public static DeferredItem<BlockItem> registerBI(String name, DeferredBlock<Block> block) {
        return ModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(),new Item.Properties()
                        .setId(ResourceKey.create(Registries.ITEM,
                                ResourceLocation.fromNamespaceAndPath(name,WIWWIMC.MODID)))));
    }
    //  --  BLOCKS --
    public static DeferredBlock<Block> IRON_TILE = registerMetalBlock(
            "iron_tile",MapColor.COLOR_BLACK,SoundType.IRON);
}
