/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package io.github.luafoxscosmicinsanity.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import java.util.Map;

import io.github.luafoxscosmicinsanity.world.inventory.StatsMenu;
import io.github.luafoxscosmicinsanity.world.inventory.ClonerMenu;
import io.github.luafoxscosmicinsanity.network.MenuStateUpdateMessage;
import io.github.luafoxscosmicinsanity.LuafoxsCosmicInsanityMod;

public class LuafoxsCosmicInsanityModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, LuafoxsCosmicInsanityMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<StatsMenu>> STATS = REGISTRY.register("stats", () -> IMenuTypeExtension.create(StatsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ClonerMenu>> CLONER = REGISTRY.register("cloner", () -> IMenuTypeExtension.create(ClonerMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof LuafoxsCosmicInsanityModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}