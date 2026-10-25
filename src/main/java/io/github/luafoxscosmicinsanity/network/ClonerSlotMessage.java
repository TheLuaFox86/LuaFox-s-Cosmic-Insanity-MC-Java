package io.github.luafoxscosmicinsanity.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

import io.github.luafoxscosmicinsanity.procedures.CosmicGeneratorOnTickUpdateProcedure;
import io.github.luafoxscosmicinsanity.procedures.ComsicClonerOnTickUpdateProcedure;
import io.github.luafoxscosmicinsanity.LuafoxsCosmicInsanityMod;

@EventBusSubscriber
public record ClonerSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) implements CustomPacketPayload {
	public static final Type<ClonerSlotMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(LuafoxsCosmicInsanityMod.MODID, "cloner_slots"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ClonerSlotMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ClonerSlotMessage message) -> {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}, (RegistryFriendlyByteBuf buffer) -> new ClonerSlotMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<ClonerSlotMessage> type() {
		return TYPE;
	}

	public static void handleData(final ClonerSlotMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleSlotAction(context.player(), message.slotID, message.changeType, message.meta, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (slot == 2 && changeType == 0) {

			ComsicClonerOnTickUpdateProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 2 && changeType == 2) {
			int amount = meta;

			ComsicClonerOnTickUpdateProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 1 && changeType == 0) {

			ComsicClonerOnTickUpdateProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 1 && changeType == 1) {
			int amount = meta;

			CosmicGeneratorOnTickUpdateProcedure.execute(world, x, y, z);
		}
		if (slot == 0 && changeType == 0) {

			ComsicClonerOnTickUpdateProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LuafoxsCosmicInsanityMod.addNetworkMessage(ClonerSlotMessage.TYPE, ClonerSlotMessage.STREAM_CODEC, ClonerSlotMessage::handleData);
	}
}