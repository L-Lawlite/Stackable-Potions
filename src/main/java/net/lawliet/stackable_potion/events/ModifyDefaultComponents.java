package net.lawliet.stackable_potion.events;

import net.lawliet.stackable_potion.Config;
import net.lawliet.stackable_potion.StackablePotionMod;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

@EventBusSubscriber(modid = StackablePotionMod.MODID)
public class ModifyDefaultComponents {
    @SubscribeEvent
    public static void modifyItem(ModifyDefaultComponentsEvent event) {
        event.modify(Items.POTION, b -> b.set(DataComponents.MAX_STACK_SIZE, Config.potionStackNumber));
        event.modify(Items.SPLASH_POTION, b -> b.set(DataComponents.MAX_STACK_SIZE,Config.splashPotionStackNumber));
        event.modify(Items.LINGERING_POTION, b -> b.set(DataComponents.MAX_STACK_SIZE,Config.LingeringPotionStackNumber));
    }
}
