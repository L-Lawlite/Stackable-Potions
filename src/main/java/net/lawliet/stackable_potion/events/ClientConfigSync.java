package net.lawliet.stackable_potion.events;

import net.lawliet.stackable_potion.CommonConfig;
import net.lawliet.stackable_potion.PotionStacks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;

@EventBusSubscriber(modid = PotionStacks.MODID, value = Dist.CLIENT)
public class ClientConfigSync {

    @SubscribeEvent
    static void onLoggedOut(ClientPlayerNetworkEvent.LoggingOut event) {
        CommonConfig.loadConfig();
    }
}
