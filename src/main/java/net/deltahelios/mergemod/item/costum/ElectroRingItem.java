package net.deltahelios.mergemod.item.costum;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Objects;

public class ElectroRingItem extends Item {


    public ElectroRingItem(Settings settings) {
        super(settings);
    }

    RegistryEntry.Reference<EntityType<?>> entityType = EntityType.LIGHTNING_BOLT.getRegistryEntry();



    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        BlockEntity blockEntity;
        World world = context.getWorld();
        if (!(world instanceof ServerWorld)) {
            return ActionResult.SUCCESS;
        }
        ItemStack itemStack = context.getStack();
        BlockPos blockPos = context.getBlockPos();
        Direction direction = context.getSide();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isOf(Blocks.SPAWNER) && (blockEntity = world.getBlockEntity(blockPos)) instanceof MobSpawnerBlockEntity) {
            MobSpawnerBlockEntity mobSpawnerBlockEntity = (MobSpawnerBlockEntity)blockEntity;
            EntityType<?> entityType = EntityType.LIGHTNING_BOLT;
            mobSpawnerBlockEntity.setEntityType(entityType, world.getRandom());
            blockEntity.markDirty();
            world.updateListeners(blockPos, blockState, blockState, Block.NOTIFY_ALL);
            world.emitGameEvent((Entity)context.getPlayer(), GameEvent.BLOCK_CHANGE, blockPos);
        }
        BlockPos blockPos2 = blockState.getCollisionShape(world, blockPos).isEmpty() ? blockPos : blockPos.offset(direction);
        EntityType<?> entityType2 = EntityType.LIGHTNING_BOLT;
        if (entityType2.spawnFromItemStack((ServerWorld)world, itemStack, context.getPlayer(), blockPos2, SpawnReason.TRIGGERED, true, !Objects.equals(blockPos, blockPos2) && direction == Direction.UP) != null) {
            world.emitGameEvent((Entity)context.getPlayer(), GameEvent.ENTITY_PLACE, blockPos);
        }
        context.getPlayer().getItemCooldownManager().set(this, 150);
        return ActionResult.SUCCESS;




    }
}
