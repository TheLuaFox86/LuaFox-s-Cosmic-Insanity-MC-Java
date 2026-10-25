/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package io.github.luafoxscosmicinsanity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import io.github.luafoxscosmicinsanity.block.*;
import io.github.luafoxscosmicinsanity.LuafoxsCosmicInsanityMod;

public class LuafoxsCosmicInsanityModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(LuafoxsCosmicInsanityMod.MODID);
	public static final DeferredBlock<Block> CRYSTAL_ORE;
	public static final DeferredBlock<Block> COSMIC_GENERATOR;
	public static final DeferredBlock<Block> COSMIC_CRYSTAL_BLOCK;
	public static final DeferredBlock<Block> COSMOS_PORTAL;
	public static final DeferredBlock<Block> COSMOS_CRYSTAL_ORE;
	public static final DeferredBlock<Block> COMSIC_CLONER;
	static {
		CRYSTAL_ORE = REGISTRY.register("crystal_ore", CrystalOreBlock::new);
		COSMIC_GENERATOR = REGISTRY.register("cosmic_generator", CosmicGeneratorBlock::new);
		COSMIC_CRYSTAL_BLOCK = REGISTRY.register("cosmic_crystal_block", CosmicCrystalBlockBlock::new);
		COSMOS_PORTAL = REGISTRY.register("cosmos_portal", CosmosPortalBlock::new);
		COSMOS_CRYSTAL_ORE = REGISTRY.register("cosmos_crystal_ore", CosmosCrystalOreBlock::new);
		COMSIC_CLONER = REGISTRY.register("comsic_cloner", ComsicClonerBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}