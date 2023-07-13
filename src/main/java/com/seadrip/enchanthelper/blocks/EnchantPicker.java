package com.seadrip.enchanthelper.blocks;

import com.seadrip.enchanthelper.screens.PickerActionScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Map;

public class EnchantPicker extends EhHasGuiBlock {
    public EnchantPicker() {
        super(Properties.of());
    }

    @Override
    protected Screen getScreen() {
        return new PickerActionScreen();
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack holding = player.getItemInHand(InteractionHand.MAIN_HAND);
        if(holding.isEmpty()) {
            if(level.isClientSide) {
                player.sendSystemMessage(Component.literal("nothing in main hand"));
            }
            return InteractionResult.FAIL;

        }
        Map<Enchantment, Integer> enchants = holding.getAllEnchantments();
        if(enchants.isEmpty()) {
            if(level.isClientSide) {
                player.sendSystemMessage(Component.literal(holding.getDisplayName() + " doesn't have any enchantment"));
            }
            return InteractionResult.FAIL;
        }
        ItemStack price = player.getItemInHand(InteractionHand.OFF_HAND);
        if(!price.is(Items.LAPIS_LAZULI) || (price.getCount() < enchants.size())) {
            if(level.isClientSide) {
                player.sendSystemMessage(Component.literal("at least " + enchants.size() + " lapis_lazuli is needed"));
            }
            return InteractionResult.FAIL;
        }
        enchants.forEach((Enchantment enchant, Integer enchant_level) -> {
            ItemStack book = new ItemStack(Items.ENCHANTED_BOOK);
            EnchantedBookItem.addEnchantment(book, new EnchantmentInstance(enchant, enchant_level));
            popResource(level, pos, book);
        });
        holding.removeTagKey("Enchantments");
        price.setCount(price.getCount() - enchants.size());
        return InteractionResult.CONSUME;
    }
}