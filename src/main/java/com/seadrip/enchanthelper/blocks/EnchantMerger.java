package com.seadrip.enchanthelper.blocks;

import com.seadrip.enchanthelper.menus.MergerActionMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;

public class EnchantMerger extends EhHasGuiBlock {
    public EnchantMerger() {
        super(Properties.of());
    }

    @Override
    protected MenuProvider getInteractMenuProvider() {
        return new SimpleMenuProvider(
            (containerId, playerInv, access) -> new MergerActionMenu(containerId, playerInv),
            Component.literal("test")
        );
    }
}
