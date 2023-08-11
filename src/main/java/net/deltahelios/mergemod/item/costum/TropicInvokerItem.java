package net.deltahelios.mergemod.item.costum;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.command.PlaceCommand;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.chunk.ChunkManager;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Optional;

public abstract class TropicInvokerItem extends Item {

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
                BlockState blockState = context.getWorld().getFluidState(positionClicked).getBlockState();
                context.getWorld().setBlockState(positionClicked, blockState, Block.NO_REDRAW);
                        context.getWorld().updateListeners(positionClicked, context.getWorld().getBlockState(positionClicked), blockState, Block.NOTIFY_LISTENERS);


        }
        context.getStack().damage(1, context.getPlayer(), playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand() ));
        return ActionResult.SUCCESS;
    }

}
