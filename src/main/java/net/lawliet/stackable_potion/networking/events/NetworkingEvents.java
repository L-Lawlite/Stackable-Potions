package net.lawliet.stackable_potion.networking.events;

import net.lawliet.stackable_potion.PotionStacks;
import net.lawliet.stackable_potion.networking.ConfigSyncPacketHandler;
import net.lawliet.stackable_potion.networking.packet.StackSizePacket;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.HandlerThread;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = PotionStacks.MODID)
public class NetworkingEvents {
    @SubscribeEvent
    public static void registerPayloads(RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1")
                .executesOn(HandlerThread.MAIN);
        registrar.configurationToClient(StackSizePacket.TYPE, StackSizePacket.STREAM_CODEC, ConfigSyncPacketHandler::handleStackSizePacket);
    }
}
