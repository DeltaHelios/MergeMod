package net.deltahelios.mergemod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.deltahelios.mergemod.MergeMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AlloyForgeScreen extends HandledScreen<AlloyForgeScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(MergeMod.MOD_ID, "textures/gui/alloy_forge_gui.png");
    public AlloyForgeScreen(AlloyForgeScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX=(backgroundWidth - textRenderer.getWidth(title)/ 2);
    }



    private void renderProgressArrow(DrawContext matrices, int mouseX, int mouseY, float delta){
        renderBackground(matrices);
        super.render(matrices,mouseX,mouseY,delta);
        drawMouseoverTooltip(matrices,mouseX,mouseY);
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {

    }
}

