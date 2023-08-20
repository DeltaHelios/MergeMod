package net.deltahelios.mergemod.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.deltahelios.mergemod.MergeMod;
import net.deltahelios.mergemod.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<AlloyForgeBlockEntity> ALLOY_FORGE;

    public static void registerAllBlockEntities() {
        ALLOY_FORGE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(MergeMod.MOD_ID, "alloy_forge_block_entity"),
                FabricBlockEntityTypeBuilder.create(AlloyForgeBlockEntity::new,
                        ModBlocks.ALLOY_FORGE).build());
    }
}