package net.deltahelios.mergemod.block.entity;

import net.deltahelios.mergemod.item.ModItems;
import net.deltahelios.mergemod.screen.AlloyForgeScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AlloyForgeBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress= 0;
    private int maxProgress=64;
    public AlloyForgeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ALLOY_FORGE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return AlloyForgeBlockEntity.this.progress;
                    case 1: return AlloyForgeBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: AlloyForgeBlockEntity.this.progress = value; break;
                    case 1: AlloyForgeBlockEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }


    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Alloy Forge");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new AlloyForgeScreenHandler(syncId,playerInventory, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("alloy_forge.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt,inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("alloy_forge.progress");
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, AlloyForgeBlockEntity entity) {
        if (world.isClient()){
            return;
        }

        if (hasRecipe(entity)){
            entity.progress++;
            markDirty(world,blockPos,state);
            if(entity.progress >= entity.maxProgress){
                craftItem(entity);
            }
        }else {
            entity.resetProgress();
            markDirty(world, blockPos, state);
        }
    }

    private void resetProgress() {
        this.progress=0;
    }

    private static void craftItem(AlloyForgeBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i=0; i< entity.size(); i++){
            inventory.setStack(i, entity.getStack(i));
        }
        if(hasRecipe(entity)){
            entity.removeStack(1, 1);
            entity.setStack(2, new ItemStack(ModItems.ELECTRUM_INGOT, entity.getStack(3).getCount()+1));
        }

    }

    private static boolean hasRecipe(AlloyForgeBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i=0; i< entity.size(); i++){
            inventory.setStack(i, entity.getStack(i));
        }

        boolean hasGoldInFirstSlot = entity.getStack(1).getItem()== Items.GOLD_INGOT;

        return hasGoldInFirstSlot && canInsertAmountIntoOutputSlot(inventory, 1)
                && canInsertItemIntoOutputSlot(inventory, ModItems.ELECTRUM_INGOT);
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(3).getItem()== output || inventory.getStack(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory, int count) {
        return inventory.getStack(3).getMaxCount() > inventory.getStack(3).getCount()+count;
    }
}
