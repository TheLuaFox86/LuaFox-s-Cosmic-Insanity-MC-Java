package io.github.luafoxscosmicinsanity.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import io.github.luafoxscosmicinsanity.world.inventory.StatsMenu;
import io.github.luafoxscosmicinsanity.procedures.*;
import io.github.luafoxscosmicinsanity.init.LuafoxsCosmicInsanityModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class StatsScreen extends AbstractContainerScreen<StatsMenu> implements LuafoxsCosmicInsanityModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("luafoxs_cosmic_insanity:textures/screens/stats.png");
	private static final ResourceLocation SPRITE_0 = ResourceLocation.parse("luafoxs_cosmic_insanity:textures/screens/batterypercent.png");

	public StatsScreen(StatsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(SPRITE_0, this.leftPos + 140, this.topPos + 31, Mth.clamp((int) StatsWhileThisGUIIsOpenTickProcedure.execute(world, x, y, z) * 16, 0, 48), 0, 16, 16, 64, 16);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.luafoxs_cosmic_insanity.stats.label_empty"), 8, 4, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.luafoxs_cosmic_insanity.stats.label_stored_energy"), 49, 20, -12829636, false);
		guiGraphics.drawString(this.font, StatsEnergyPercentageProcedure.execute(world, x, y, z), 17, 33, -6710887, false);
		if (StatsOtherVisibleProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, Component.translatable("gui.luafoxs_cosmic_insanity.stats.label_other"), 66, 50, -12829636, false);
		if (StatsOtherVisibleProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, StatsGetOther1Procedure.execute(world, x, y, z), 85, 63, -6710887, false);
		if (StatsOtherVisibleProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, GetStats1NameProcedure.execute(world, x, y, z), 8, 62, -6710887, false);
		if (StatsOtherVisibleProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, GetStats2NameProcedure.execute(world, x, y, z), 9, 84, -6710887, false);
		guiGraphics.drawString(this.font, GetStats2ValueProcedure.execute(world, x, y, z), 85, 86, -6710887, false);
		if (StatsOtherVisibleProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, GetStats3NameProcedure.execute(world, x, y, z), 9, 104, -6710887, false);
		if (StatsOtherVisibleProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, GetStats3ValueProcedure.execute(world, x, y, z), 85, 106, -6710887, false);
	}

	@Override
	public void init() {
		super.init();
	}
}