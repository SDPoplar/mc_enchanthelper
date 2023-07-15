package com.seadrip.enchanthelper.menus;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.inventory.ItemCombinerMenuSlotDefinition;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class MergerActionMenu extends ItemCombinerMenu {
    public MergerActionMenu(MenuType type, int a, Inventory inventory) {
        super(type, a, inventory, ContainerLevelAccess.NULL);
    }

    public MergerActionMenu(MenuType type, int a, Inventory inventory, ContainerLevelAccess access) {
        super(type, a, inventory, access);
    }

    @Override
    protected boolean mayPickup(Player p_39798_, boolean p_39799_) {
        return false;
    }

    @Override
    protected void onTake(Player p_150601_, ItemStack p_150602_) {

    }

    @Override
    protected boolean isValidBlock(BlockState p_39788_) {
        return false;
    }

    @Override
    public void createResult() {

    }

    @Override
    protected ItemCombinerMenuSlotDefinition createInputSlotDefinitions() {
        return null;
    }
}
