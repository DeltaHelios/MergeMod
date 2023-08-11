package net.deltahelios.mergemod.item.costum;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.*;

public class TropicInvokerItem extends Item {

    public TropicInvokerItem(Settings settings) {
        super(settings);
    }



    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();

            RegistryKey<ConfiguredFeature<?, ?>> registryKey = TreeConfiguredFeatures.MEGA_JUNGLE_TREE;
            RegistryEntry registryEntry = context.getWorld().getRegistryManager().get(RegistryKeys.CONFIGURED_FEATURE).getEntry(registryKey).orElse(null);
            ConfiguredFeature configuredFeature = (ConfiguredFeature)registryEntry.value();

            if(configuredFeature.generate(player.getServer().getWorld(context.getWorld().getRegistryKey()), player.getServer().getWorld(context.getWorld().getRegistryKey()).getChunkManager().getChunkGenerator(), Random.create(0), positionClicked)) {
                BlockState blockState = context.getWorld().getFluidState(positionClicked).getBlockState();
                context.getWorld().setBlockState(positionClicked, blockState, Block.NO_REDRAW);
                    if (context.getWorld().getBlockState(positionClicked) == blockState) {
                        context.getWorld().updateListeners(positionClicked, context.getWorld().getBlockState(positionClicked), blockState, Block.NOTIFY_LISTENERS);
                    }
                context.getPlayer().getItemCooldownManager().set(this, 600);
                context.getStack().damage(1, context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand() ));


            }else {
                player.sendMessage(Text.literal("§2Not enough space for invoking ceremony."), true);
                context.getPlayer().getItemCooldownManager().set(this, 50);

            }
            return ActionResult.SUCCESS;



        }
        return ActionResult.FAIL;
    }


}