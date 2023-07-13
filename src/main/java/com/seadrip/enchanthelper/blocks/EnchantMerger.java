package com.seadrip.enchanthelper.blocks;

import com.seadrip.enchanthelper.screens.MergerActionScreen;
import net.minecraft.client.gui.screens.Screen;

public class EnchantMerger extends EhHasGuiBlock {
    public EnchantMerger() {
        super(Properties.of());
    }

    @Override
    protected Screen getScreen() {
        return new MergerActionScreen();
    }
}
