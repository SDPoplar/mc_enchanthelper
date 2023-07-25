package com.seadrip.enchanthelper.menus;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EhMenus {
    public final RegistryObject<MenuType<MergerActionMenu>> MERGER_ACTION_MENU_TYPE;
    public final RegistryObject<MenuType<PickerActionMenu>> PICKER_ACTION_MENU_TYPE;
    public final RegistryObject<MenuType<CopierActionMenu>> COPIER_ACTION_MENU_TYPE;

    public EhMenus(DeferredRegister<MenuType<?>> register) {
        MERGER_ACTION_MENU_TYPE = register.register("merger_action_menu", () -> new MenuType(MergerActionMenu::new, FeatureFlags.DEFAULT_FLAGS));
        PICKER_ACTION_MENU_TYPE = register.register("picker_action_menu", () -> new MenuType(PickerActionMenu::new, FeatureFlags.DEFAULT_FLAGS));
        COPIER_ACTION_MENU_TYPE = register.register("copier_action_menu", () -> new MenuType(CopierActionMenu::new, FeatureFlags.DEFAULT_FLAGS));
    }
}
