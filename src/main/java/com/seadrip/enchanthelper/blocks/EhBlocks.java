package com.seadrip.enchanthelper.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EhBlocks {

    // Creates a new Block with the id "enchanthelper:enchant_picker", combining the namespace and path
    public final RegistryObject<Block> ENCHANT_PICKER;
    // Creates a new BlockItem with the id "enchanthelper:enchant_picker_item", combining the namespace and path
    public final RegistryObject<Item> ENCHANT_PICKER_ITEM;

    public final RegistryObject<Block> ENCHANT_COPIER;
    public final RegistryObject<Item> ENCHANT_COPIER_ITEM;

    public final RegistryObject<Block> ENCHANT_MERGER;
    public final RegistryObject<Item> ENCHANT_MERGER_ITEM;

    public EhBlocks(DeferredRegister<Block> br, DeferredRegister<Item> ir) {
        ENCHANT_PICKER = br.register("enchant_picker", EnchantPicker::new);
        ENCHANT_PICKER_ITEM = ir.register("enchant_picker_item", () -> new BlockItem(ENCHANT_PICKER.get(), new Item.Properties()));

        ENCHANT_COPIER = br.register("enchant_copier", EnchantCopier::new);
        ENCHANT_COPIER_ITEM = ir.register("enchant_copier_item", () -> new BlockItem(ENCHANT_COPIER.get(), new Item.Properties()));

        ENCHANT_MERGER = br.register("enchant_merger", EnchantMerger::new);
        ENCHANT_MERGER_ITEM = ir.register("enchant_merger_item", () -> new BlockItem(ENCHANT_MERGER.get(), new Item.Properties()));
    }
}