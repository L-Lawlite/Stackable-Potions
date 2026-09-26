package net.lawliet.stackable_potion.networking;

import net.lawliet.stackable_potion.CommonConfig;
import net.lawliet.stackable_potion.networking.packet.StackSizePacket;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class ConfigSyncPacketHandler {

    public static void handleStackSizePacket(StackSizePacket packet, IPayloadContext context) {
        CommonConfig.potionStackNumber = packet.potionStackSize();
        CommonConfig.splashPotionStackNumber = packet.splashPotionStackSize();
        CommonConfig.lingeringPotionStackNumber = packet.lingeringPotionStackSize();
    }
}
