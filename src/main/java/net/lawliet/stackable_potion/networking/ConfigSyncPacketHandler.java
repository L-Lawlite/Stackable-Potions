package net.lawliet.stackable_potion.networking;

import net.lawliet.stackable_potion.CommonConfig;
import net.lawliet.stackable_potion.networking.packet.StackSizePacket;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class ConfigSyncPacketHandler {

    public static void handleStackSizePacket(StackSizePacket packet, IPayloadContext context) {
        String name = packet.name();
        int stackSize = packet.stackSize();
        switch(name) {
            case "potionStackSize" -> CommonConfig.potionStackNumber = stackSize;
            case "splashPotionStackSize" -> CommonConfig.splashPotionStackNumber = stackSize;
            case "lingeringPotionStackSize" -> CommonConfig.lingeringPotionStackNumber = stackSize;
        }
    }
}
