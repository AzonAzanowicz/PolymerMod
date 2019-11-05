package azon.polymer.screens;

import azon.polymer.Polymer;
import azon.polymer.containers.ContainerGeneratorSolidFuel;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import java.awt.*;

public class ScreenGeneratorSolidFuel extends ContainerScreen<ContainerGeneratorSolidFuel> {

    private ResourceLocation GUI = new ResourceLocation(Polymer.MOD_ID, "textures/gui/generator_solid_fuel.png");

    public ScreenGeneratorSolidFuel(ContainerGeneratorSolidFuel container, PlayerInventory inv, ITextComponent title) {
        super(container, inv, title);
        xSize = 176;
        ySize = 166;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.font.drawString(this.title.getFormattedText(), 8.0F, 6.0F, 4210752);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, 72.0F, 4210752);
        this.font.drawString(""+this.container.getBurnLeftFraction(), 20.0F, 20.0F, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(i, j, 0, 0, this.xSize, this.ySize);

        progressBarUp(1 - this.container.getBurnLeftFraction(), 80, 26, 176, 0, 14, 14);
        progressBarUp(this.container.getBurnLeftFraction(), 152, 9, 176, 14, 16, 60);


    }

    protected void progressBarUp(float f, int width1, int height1, int width2, int height2, int sizeWidth, int sizeHeigh) {
        int i = this.guiLeft;
        int j = this.guiTop;
        int k = (int)((1 - f) * sizeHeigh);

        this.blit(i + width1, j + height1 + k, width2, height2 + k, sizeWidth, sizeHeigh - k);
    }
}