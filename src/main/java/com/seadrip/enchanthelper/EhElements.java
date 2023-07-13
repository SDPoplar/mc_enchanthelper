package com.seadrip.enchanthelper;

import com.seadrip.enchanthelper.blocks.EhBlocks;
import com.seadrip.enchanthelper.items.EhItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EhElements {

    // Create a Deferred Register to hold Blocks which will all be registered under the "enchanthelper" namespace
    private final DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, EnchantHelper.MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "enchanthelper" namespace
    private final DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, EnchantHelper.MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "enchanthelper" namespace
    private final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EnchantHelper.MODID);

    public final EhBlocks BLOCKS = new EhBlocks(BLOCK_REGISTER, ITEM_REGISTER);
    public final EhItems ITEMS = new EhItems(ITEM_REGISTER);

    // Creates a creative tab with the id "enchanthelper:enchant_helper_tab" for the example item, that is placed after the combat tab
    private final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("enchant_helper_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            //.icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                //output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());

    public void RegisterToBus(IEventBus bus) {
        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCK_REGISTER.register(bus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEM_REGISTER.register(bus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(bus);
    }
}
