package com.seadrip.enchanthelper.screens;

import com.seadrip.enchanthelper.EnchantHelper;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class PickerActionScreen extends Screen {
    private static final ResourceLocation BACKGROUND_IMAGE = new ResourceLocation(EnchantHelper.MODID, "textures/screen/enchant_picker/background.png");
    protected final static Button BTN_GO = Button.builder(Component.literal("GO!"), (Button btn) -> {})
            .width(80)
            .pos(100, 60)
            .build();

    public PickerActionScreen() {
        super(Component.literal("picker screen"));
    }

    @Override
    protected void init() {
        this.addWidget(BTN_GO);
        super.init();
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);
        graphics.blit(BACKGROUND_IMAGE, 0, 0, 0, 0, 180, 120);
        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void onClose() {
        super.onClose();
    }

    @Override
    public void removed() {
        super.removed();
    }

    public void onGoButtonClick() {

    }
}
