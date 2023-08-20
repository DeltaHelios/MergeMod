package net.deltahelios.mergemod.mixin;

import net.deltahelios.mergemod.MergeMod;
import net.deltahelios.mergemod.item.ModItems;
import net.deltahelios.mergemod.mixin.ItemRenderAccessor;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useHemlockStaffModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(ModItems.HEMLOCK_STAFF) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRenderAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(MergeMod.MOD_ID, "hemlock_staff_3d", "inventory"));
        }
        return value;
    }
}