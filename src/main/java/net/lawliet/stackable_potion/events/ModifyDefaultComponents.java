package net.lawliet.stackable_potion.events;

import net.lawliet.stackable_potion.ServerConfig;
import net.lawliet.stackable_potion.PotionStacks;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

@EventBusSubscriber(modid = PotionStacks.MODID)
public class ModifyDefaultComponents {
    @SubscribeEvent
    public static void modifyItem(ModifyDefaultComponentsEvent event) {
        event.modify(Items.POTION, (components, _, _) -> components.set(DataComponents.MAX_STACK_SIZE, ServerConfig.potionStackNumber));
        event.modify(Items.SPLASH_POTION, (components, _, _) -> components.set(DataComponents.MAX_STACK_SIZE, ServerConfig.splashPotionStackNumber));
        event.modify(Items.LINGERING_POTION, (components, _, _) -> components.set(DataComponents.MAX_STACK_SIZE, ServerConfig.LingeringPotionStackNumber));
    }
}
