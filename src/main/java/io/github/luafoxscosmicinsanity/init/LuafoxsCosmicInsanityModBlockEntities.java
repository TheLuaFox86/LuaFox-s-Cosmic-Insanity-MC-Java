/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package io.github.luafoxscosmicinsanity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import io.github.luafoxscosmicinsanity.block.entity.CosmicGeneratorBlockEntity;
import io.github.luafoxscosmicinsanity.block.entity.ComsicClonerBlockEntity;
import io.github.luafoxscosmicinsanity.LuafoxsCosmicInsanityMod;

@EventBusSubscriber
public class LuafoxsCosmicInsanityModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, LuafoxsCosmicInsanityMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CosmicGeneratorBlockEntity>> COSMIC_GENERATOR = register("cosmic_generator", LuafoxsCosmicInsanityModBlocks.COSMIC_GENERATOR, CosmicGeneratorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ComsicClonerBlockEntity>> COMSIC_CLONER = register("comsic_cloner", LuafoxsCosmicInsanityModBlocks.COMSIC_CLONER, ComsicClonerBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, COSMIC_GENERATOR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, COSMIC_GENERATOR.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, COMSIC_CLONER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, COMSIC_CLONER.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
	}
}