/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package io.github.luafoxscosmicinsanity.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import io.github.luafoxscosmicinsanity.client.gui.StatsScreen;
import io.github.luafoxscosmicinsanity.client.gui.ClonerScreen;

@EventBusSubscriber(Dist.CLIENT)
public class LuafoxsCosmicInsanityModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(LuafoxsCosmicInsanityModMenus.STATS.get(), StatsScreen::new);
		event.register(LuafoxsCosmicInsanityModMenus.CLONER.get(), ClonerScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}