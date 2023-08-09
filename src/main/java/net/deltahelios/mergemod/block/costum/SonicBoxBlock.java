package net.deltahelios.mergemod.block.costum;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SonicBoxBlock extends Block {
    public SonicBoxBlock(Settings settings){
        super(settings);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){

        world.playSound(player, pos, SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT, SoundCategory.BLOCKS, 1f, 2f);
        player.addVelocity((player.getX()- pos.getX())/2f, (player.getY() - pos.getY())/2f,(player.getZ()- pos.getZ())/2f);
        return ActionResult.SUCCESS;
    }
}
