package net.lawliet.stackable_potion;

import net.lawliet.stackable_potion.config.task.StackSizeSyncTask;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.network.event.RegisterConfigurationTasksEvent;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = PotionStacks.MODID)
public class CommonConfig
{

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.IntValue POTION_STACK_SIZE = BUILDER
            .worldRestart()
            .comment("Stack Size for Drinkable Potion")
            .defineInRange("potionStackSize", 3, 0, 64);

    public static final ModConfigSpec.IntValue SPLASH_POTION_STACK_SIZE = BUILDER
            .worldRestart()
            .comment("Stack Size for Splash Potion")
            .defineInRange("splashPotionStackSize", 3, 0, 64);

    public static final ModConfigSpec.IntValue LINGERING_POTION_STACK_SIZE = BUILDER
            .worldRestart()
            .comment("Stack Size for Lingering Potion")
            .defineInRange("lingeringPotionStackSize", 3, 0, 64);


    static final ModConfigSpec SPEC = BUILDER.build();

    public static int potionStackNumber, splashPotionStackNumber, lingeringPotionStackNumber;

    private static void loadConfig() {
        potionStackNumber = POTION_STACK_SIZE.get();
        splashPotionStackNumber = SPLASH_POTION_STACK_SIZE.get();
        lingeringPotionStackNumber = LINGERING_POTION_STACK_SIZE.get();
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent.Loading event)
    {
        if (event.getConfig().getSpec() == SPEC) {
            loadConfig();
        }
    }

    @SubscribeEvent
    static void onReload(final ModConfigEvent.Reloading event)
    {
        if (event.getConfig().getSpec() == SPEC) {
            loadConfig();
        }
    }

    @SubscribeEvent
    static void syncWithModdedClient(RegisterConfigurationTasksEvent event) {
            event.register(new StackSizeSyncTask(event.getListener()));
    }

    @SubscribeEvent
    static void onLoggedOut(ClientPlayerNetworkEvent.LoggingOut event) {
        loadConfig();
    }

}
