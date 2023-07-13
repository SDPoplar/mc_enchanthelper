package com.seadrip.enchanthelper.blocks;

import com.seadrip.enchanthelper.screens.CopierActionScreen;
import net.minecraft.client.gui.screens.Screen;

public class EnchantCopier extends EhHasGuiBlock {
    public EnchantCopier() {
        super(Properties.of());
    }

    @Override
    protected Screen getScreen() {
        return new CopierActionScreen();
    }
}
