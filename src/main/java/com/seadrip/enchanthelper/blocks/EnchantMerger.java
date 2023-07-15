package com.seadrip.enchanthelper.blocks;

import com.seadrip.enchanthelper.menus.MergerActionMenu;
import net.minecraft.world.MenuProvider;

public class EnchantMerger extends EhHasGuiBlock {
    public EnchantMerger() {
        super(Properties.of());
    }

    @Override
    protected MenuProvider getInteractMenuProvider() {
        return null;
    }
}
