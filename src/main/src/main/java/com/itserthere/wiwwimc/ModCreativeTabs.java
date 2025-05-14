package com.itserthere.wiwwimc;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.itserthere.wiwwimc.ModBlocks.*;
import static com.itserthere.wiwwimc.ModItems.*;
import static com.itserthere.wiwwimc.WIWWIMC.*;
import static net.minecraft.world.item.CreativeModeTabs.INGREDIENTS;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_DEFERRED_REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(eventBus);
    }
    // -- WIWWIMC CREATIVE TAB FOR BLOCKS --
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WIWWIMC_BLOCKS =
            CREATIVE_MODE_TABS.register("wiwwimc_blocks", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.wiwwimc.wiwwimc_blocks")) //TRANSLATION: DO NOT CHANGE
                    .withTabsBefore(INGREDIENTS)
                    .icon(() -> IRON_TILE_ITEM.get().getDefaultInstance()) //ICON - DO NOT CHANGE
                    .displayItems((parameters, output) -> { //ADD ITEMS BELOW
                        output.accept(IRON_TILE_ITEM.get());
                    }).build());
}
