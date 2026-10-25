/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package io.github.luafoxscosmicinsanity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import io.github.luafoxscosmicinsanity.LuafoxsCosmicInsanityMod;

@EventBusSubscriber
public class LuafoxsCosmicInsanityModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LuafoxsCosmicInsanityMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> COSMIC_INSANITY = REGISTRY.register("cosmic_insanity", () -> CreativeModeTab.builder().title(Component.translatable("item_group.luafoxs_cosmic_insanity.cosmic_insanity"))
			.icon(() -> new ItemStack(LuafoxsCosmicInsanityModItems.COSMIC_CRYSTAL_PICKAXE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(LuafoxsCosmicInsanityModItems.COSMIC_CRYSTAL.get());
				tabData.accept(LuafoxsCosmicInsanityModBlocks.CRYSTAL_ORE.get().asItem());
				tabData.accept(LuafoxsCosmicInsanityModItems.COSMIC_CRYSTAL_PICKAXE.get());
				tabData.accept(LuafoxsCosmicInsanityModBlocks.COSMIC_GENERATOR.get().asItem());
				tabData.accept(LuafoxsCosmicInsanityModBlocks.COSMIC_CRYSTAL_BLOCK.get().asItem());
				tabData.accept(LuafoxsCosmicInsanityModItems.COMSIC_CRYSTAL_SWORD.get());
				tabData.accept(LuafoxsCosmicInsanityModItems.COSMIC_MULTI_TOOL.get());
				tabData.accept(LuafoxsCosmicInsanityModBlocks.COSMOS_CRYSTAL_ORE.get().asItem());
				tabData.accept(LuafoxsCosmicInsanityModBlocks.COMSIC_CLONER.get().asItem());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(LuafoxsCosmicInsanityModItems.COSMIC_CRYSTAL.get());
			tabData.accept(LuafoxsCosmicInsanityModBlocks.COSMIC_CRYSTAL_BLOCK.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(LuafoxsCosmicInsanityModBlocks.CRYSTAL_ORE.get().asItem());
			tabData.accept(LuafoxsCosmicInsanityModBlocks.COSMOS_CRYSTAL_ORE.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(LuafoxsCosmicInsanityModItems.COSMIC_CRYSTAL_PICKAXE.get());
			tabData.accept(LuafoxsCosmicInsanityModItems.COSMIC_MULTI_TOOL.get());
			tabData.accept(LuafoxsCosmicInsanityModItems.COSMOS.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(LuafoxsCosmicInsanityModBlocks.COSMIC_CRYSTAL_BLOCK.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(LuafoxsCosmicInsanityModItems.COMSIC_CRYSTAL_SWORD.get());
			tabData.accept(LuafoxsCosmicInsanityModItems.COSMIC_MULTI_TOOL.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			tabData.accept(LuafoxsCosmicInsanityModBlocks.COMSIC_CLONER.get().asItem());
		}
	}
}