package com.seadrip.enchanthelper.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Map;

public class EnchantCopier extends EhHasGuiBlock {
    public EnchantCopier() {
        super(Properties.of());
    }

    @Override
    protected MenuProvider getInteractMenuProvider() {
        return null;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(!player.getItemInHand(InteractionHand.MAIN_HAND).is(Items.ENCHANTED_BOOK)) {
            if(level.isClientSide) {
                player.sendSystemMessage(Component.literal("You should hold an enchanted book in your main hand"));
            }
            return InteractionResult.FAIL;
        }
        Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(player.getItemInHand(InteractionHand.MAIN_HAND));
        int consumeLapis = enchants.size();
        ItemStack lapis = player.getItemInHand(InteractionHand.OFF_HAND);
        if(lapis.getCount() < consumeLapis) {
            if(level.isClientSide) {
                player.sendSystemMessage(Component.literal("No enough lapis in hand, at least " + consumeLapis + " is needed"));
            }
            return InteractionResult.FAIL;
        }
        enchants.forEach((Enchantment enchant, Integer enchant_level) -> {
            ItemStack book = new ItemStack(Items.ENCHANTED_BOOK);
            EnchantedBookItem.addEnchantment(book, new EnchantmentInstance(enchant, enchant_level));
            popResource(level, pos, book);
        });
        lapis.setCount(lapis.getCount() - consumeLapis);
        return InteractionResult.CONSUME;
    }
}
