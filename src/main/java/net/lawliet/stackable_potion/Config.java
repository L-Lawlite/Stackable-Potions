package net.lawliet.stackable_potion;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = StackablePotionMod.MODID)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.IntValue POTION_STACK_NUMBER = BUILDER
            .comment("Stack Number for Drinkable Potion")
            .defineInRange("potionStackNumber", 3, 0, 64);

    private static final ModConfigSpec.IntValue SPLASH_POTION_STACK_NUMBER = BUILDER
            .comment("Stack Number for Splash Potion")
            .defineInRange("splashPotionStackNumber", 3, 0, 64);

    private static final ModConfigSpec.IntValue LINGERING_POTION_STACK_NUMBER = BUILDER
            .comment("Stack Number for Lingering Potion")
            .defineInRange("lingeringPotionStackNumber", 3, 0, 64);


    static final ModConfigSpec SPEC = BUILDER.build();

    public static int potionStackNumber,splashPotionStackNumber,LingeringPotionStackNumber;



    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        potionStackNumber = POTION_STACK_NUMBER.get();
        splashPotionStackNumber = SPLASH_POTION_STACK_NUMBER.get();
        LingeringPotionStackNumber = LINGERING_POTION_STACK_NUMBER.get();

    }
}
