package com.seadrip.enchanthelper.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public abstract class EhHasGuiBlock extends Block {
    public EhHasGuiBlock(Properties prop) {
        super(prop);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(level.isClientSide) {
            player.openMenu(getInteractMenuProvider());
        }
        return InteractionResult.CONSUME;
    }

    abstract protected MenuProvider getInteractMenuProvider();
}
