package io.github.luafoxscosmicinsanity.procedures;

import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import io.github.luafoxscosmicinsanity.init.LuafoxsCosmicInsanityModMenus;

public class ComsicClonerOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double FuelSlot = 0;
		double OutputSlot = 0;
		double PresetSlot = 0;
		double FEtoConsume = 0;
		FuelSlot = 0;
		PresetSlot = 2;
		OutputSlot = 1;
		FEtoConsume = 100;
		if (getEnergyStored(world, BlockPos.containing(x, y, z), null) > FEtoConsume) {
			if (getAmountInGUISlot(entity, (int) FuelSlot) > 0) {
				if (getAmountInGUISlot(entity, 1) < (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof LuafoxsCosmicInsanityModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getMaxStackSize()) {
					if (entity instanceof Player _player && _player.containerMenu instanceof LuafoxsCosmicInsanityModMenus.MenuAccessor _menu) {
						ItemStack _setstack7 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof LuafoxsCosmicInsanityModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get((int) FuelSlot).getItem() : ItemStack.EMPTY)
								.copy();
						_setstack7.setCount(getAmountInGUISlot(entity, (int) FuelSlot) - 1);
						_menu.getSlots().get((int) FuelSlot).set(_setstack7);
						ItemStack _setstack10 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof LuafoxsCosmicInsanityModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(2).getItem() : ItemStack.EMPTY).copy();
						_setstack10.setCount(getAmountInGUISlot(entity, 1) + 1);
						_menu.getSlots().get(1).set(_setstack10);
						_player.containerMenu.broadcastChanges();
					}
					if (world instanceof ILevelExtension _ext) {
						IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
						if (_entityStorage != null)
							_entityStorage.extractEnergy((int) FEtoConsume, false);
					}
				}
			}
		}
	}

	public static int getEnergyStored(LevelAccessor level, BlockPos pos, Direction direction) {
		if (level instanceof ILevelExtension levelExtension) {
			IEnergyStorage energyStorage = levelExtension.getCapability(Capabilities.EnergyStorage.BLOCK, pos, direction);
			if (energyStorage != null)
				return energyStorage.getEnergyStored();
		}
		return 0;
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof LuafoxsCosmicInsanityModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}