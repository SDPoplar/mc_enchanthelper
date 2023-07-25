package com.seadrip.enchanthelper.menus;

import com.seadrip.enchanthelper.EhElements;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class CopierActionMenu extends AbstractContainerMenu {
    public CopierActionMenu(int containerId, Inventory playerInv) {
        super(EhElements.MENUS.COPIER_ACTION_MENU_TYPE.get(), containerId);
    }

    @Override
    public ItemStack quickMoveStack(Player p_38941_, int p_38942_) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return false;
    }
}
