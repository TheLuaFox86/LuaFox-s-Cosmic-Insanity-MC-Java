/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package io.github.luafoxscosmicinsanity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import io.github.luafoxscosmicinsanity.item.CosmosItem;
import io.github.luafoxscosmicinsanity.item.CosmicMultiToolItem;
import io.github.luafoxscosmicinsanity.item.CosmicCrystalPickaxeItem;
import io.github.luafoxscosmicinsanity.item.CosmicCrystalItem;
import io.github.luafoxscosmicinsanity.item.ComsicCrystalSwordItem;
import io.github.luafoxscosmicinsanity.LuafoxsCosmicInsanityMod;

public class LuafoxsCosmicInsanityModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(LuafoxsCosmicInsanityMod.MODID);
	public static final DeferredItem<Item> COSMIC_CRYSTAL;
	public static final DeferredItem<Item> CRYSTAL_ORE;
	public static final DeferredItem<Item> COSMIC_CRYSTAL_PICKAXE;
	public static final DeferredItem<Item> COSMIC_GENERATOR;
	public static final DeferredItem<Item> COSMIC_CRYSTAL_BLOCK;
	public static final DeferredItem<Item> COMSIC_CRYSTAL_SWORD;
	public static final DeferredItem<Item> COSMIC_MULTI_TOOL;
	public static final DeferredItem<Item> COSMOS;
	public static final DeferredItem<Item> COSMOS_CRYSTAL_ORE;
	public static final DeferredItem<Item> COMSIC_CLONER;
	static {
		COSMIC_CRYSTAL = REGISTRY.register("cosmic_crystal", CosmicCrystalItem::new);
		CRYSTAL_ORE = block(LuafoxsCosmicInsanityModBlocks.CRYSTAL_ORE, new Item.Properties().rarity(Rarity.RARE).fireResistant());
		COSMIC_CRYSTAL_PICKAXE = REGISTRY.register("cosmic_crystal_pickaxe", CosmicCrystalPickaxeItem::new);
		COSMIC_GENERATOR = block(LuafoxsCosmicInsanityModBlocks.COSMIC_GENERATOR);
		COSMIC_CRYSTAL_BLOCK = block(LuafoxsCosmicInsanityModBlocks.COSMIC_CRYSTAL_BLOCK);
		COMSIC_CRYSTAL_SWORD = REGISTRY.register("comsic_crystal_sword", ComsicCrystalSwordItem::new);
		COSMIC_MULTI_TOOL = REGISTRY.register("cosmic_multi_tool", CosmicMultiToolItem::new);
		COSMOS = REGISTRY.register("cosmos", CosmosItem::new);
		COSMOS_CRYSTAL_ORE = block(LuafoxsCosmicInsanityModBlocks.COSMOS_CRYSTAL_ORE, new Item.Properties().rarity(Rarity.EPIC).fireResistant());
		COMSIC_CLONER = block(LuafoxsCosmicInsanityModBlocks.COMSIC_CLONER, new Item.Properties().rarity(Rarity.RARE));
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}