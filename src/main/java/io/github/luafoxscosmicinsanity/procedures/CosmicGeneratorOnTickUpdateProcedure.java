package io.github.luafoxscosmicinsanity.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class CosmicGeneratorOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ILevelExtension _ext) {
			IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), Direction.UP);
			if (_entityStorage != null)
				_entityStorage.receiveEnergy(500000, false);
		}
		if (world instanceof ILevelExtension _ext) {
			IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y + 1, z), Direction.DOWN);
			if (_entityStorage != null)
				_entityStorage.receiveEnergy(650000, false);
		}
		if (world instanceof ILevelExtension _ext) {
			IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y - 1, z), Direction.UP);
			if (_entityStorage != null)
				_entityStorage.receiveEnergy(650000, false);
		}
		if (world instanceof ILevelExtension _ext) {
			IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z + 1), Direction.NORTH);
			if (_entityStorage != null)
				_entityStorage.receiveEnergy(650000, false);
		}
		if (world instanceof ILevelExtension _ext) {
			IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z - 1), Direction.SOUTH);
			if (_entityStorage != null)
				_entityStorage.receiveEnergy(650000, false);
		}
		if (world instanceof ILevelExtension _ext) {
			IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x + 1, y, z), Direction.WEST);
			if (_entityStorage != null)
				_entityStorage.receiveEnergy(650000, false);
		}
		if (world instanceof ILevelExtension _ext) {
			IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x - 1, y, z), Direction.EAST);
			if (_entityStorage != null)
				_entityStorage.receiveEnergy(650000, false);
		}
	}
}