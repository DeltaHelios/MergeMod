package net.deltahelios.mergemod.item.costum;

import net.deltahelios.mergemod.block.ModBlocks;
import net.deltahelios.mergemod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class TectonicDetectorItem extends Item {
    public TectonicDetectorItem(Settings settings){
        super(settings);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for (int i=0; i<=positionClicked.getY()+64;i++){
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                if(isValuableBlock(state)){
                    outputValuableCoordinates(positionClicked.down(i),player, state.getBlock());
                    foundBlock = true;

                    break;
                }
            }
            if(!foundBlock){
                player.sendMessage(Text.literal("No High Value Ores Found!"), true);
            }
        }
        context.getStack().damage(1, context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand() ));
        context.getPlayer().getItemCooldownManager().set(this, 100);
        return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos , PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Detected "+block.asItem().getName().getString() + " at y coordinates " + blockPos.getY()), true);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isIn(ModTags.Blocks.TECTONIC_DETECTOR_DETECTABLE_BLOCKS);
    }
    @Override
    public Rarity getRarity(ItemStack stack) {

        return Rarity.EPIC;
    }

}
