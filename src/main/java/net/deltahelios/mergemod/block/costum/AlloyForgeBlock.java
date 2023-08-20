package net.deltahelios.mergemod.block.costum;

import net.deltahelios.mergemod.block.entity.AlloyForgeBlockEntity;
import net.deltahelios.mergemod.block.entity.ModBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


import java.util.stream.Stream;

public class AlloyForgeBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.FACING;
    public AlloyForgeBlock(Settings settings) {

        super(settings);
    }
    public static VoxelShape SHAPE_NS = Stream.of(
            Block.createCuboidShape(4, 4, 4, 12, 5, 12),
            Block.createCuboidShape(4, 10, 4, 12, 11, 12),
            Block.createCuboidShape(3, 0, 3, 13, 1, 13),
            Block.createCuboidShape(5, 0, 5, 11, 7, 11),
            Block.createCuboidShape(1, 13, 1, 5, 16, 15),
            Block.createCuboidShape(11, 13, 1, 15, 16, 15),
            Block.createCuboidShape(5, 13, 11, 11, 14, 15),
            Block.createCuboidShape(5, 13, 1, 11, 14, 5),
            Block.createCuboidShape(5, 14, 13, 11, 15, 15),
            Block.createCuboidShape(5, 14, 1, 11, 15, 3),
            Block.createCuboidShape(5, 8, 5, 11, 13, 11),
            Block.createCuboidShape(4, 7, 4, 12, 8, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static VoxelShape SHAPE_EW = Stream.of(
            Block.createCuboidShape(4, 4, 4, 12, 5, 12),
            Block.createCuboidShape(4, 10, 4, 12, 11, 12),
            Block.createCuboidShape(3, 0, 3, 13, 1, 13),
            Block.createCuboidShape(5, 0, 5, 11, 7, 11),
            Block.createCuboidShape(1, 13, 1, 15, 16, 5),
            Block.createCuboidShape(1, 13, 11, 15, 16, 15),
            Block.createCuboidShape(1, 13, 5, 5, 14, 11),
            Block.createCuboidShape(11, 13, 5, 15, 14, 11),
            Block.createCuboidShape(1, 14, 5, 3, 15, 11),
            Block.createCuboidShape(13, 14, 5, 15, 15, 11),
            Block.createCuboidShape(5, 8, 5, 11, 13, 11),
            Block.createCuboidShape(4, 7, 4, 12, 8, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)){
            case NORTH:
                return SHAPE_NS;
            case SOUTH:
                return SHAPE_NS;
            case WEST:
                return SHAPE_EW;
            case EAST:
                return SHAPE_EW;
            case UP:
                return SHAPE_NS;
            case DOWN:
                return SHAPE_NS;
            default:
                return SHAPE_NS;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());

    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    /* Block Entity Things */
    @Override
    public BlockRenderType getRenderType(BlockState state){
        return BlockRenderType.MODEL;
    }
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof AlloyForgeBlockEntity) {
                ItemScatterer.spawn(world, pos, (AlloyForgeBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = ((AlloyForgeBlockEntity) world.getBlockEntity(pos));

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }


    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.ALLOY_FORGE, AlloyForgeBlockEntity::tick);
    }
}
