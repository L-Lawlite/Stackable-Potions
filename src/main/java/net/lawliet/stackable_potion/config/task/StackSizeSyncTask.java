package net.lawliet.stackable_potion.config.task;

import net.lawliet.stackable_potion.CommonConfig;
import net.lawliet.stackable_potion.PotionStacks;
import net.lawliet.stackable_potion.networking.packet.StackSizePacket;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.configuration.ServerConfigurationPacketListener;
import net.minecraft.resources.Identifier;
import net.minecraft.server.network.ConfigurationTask;
import net.neoforged.neoforge.network.configuration.ICustomConfigurationTask;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public record StackSizeSyncTask(ServerConfigurationPacketListener listener) implements ICustomConfigurationTask {
    public static final ConfigurationTask.Type TYPE = new ConfigurationTask.Type(Identifier.fromNamespaceAndPath(PotionStacks.MODID, "stack_size_sync"));


    /**
     * Invoked when it is time for this configuration to run.
     *
     * @param sender A consumer that accepts a {@link CustomPacketPayload} to send to the client.
     */
    @Override
    public void run(Consumer<CustomPacketPayload> sender) {
        sender.accept(new StackSizePacket(
                CommonConfig.POTION_STACK_SIZE.get(),
                CommonConfig.SPLASH_POTION_STACK_SIZE.get(),
                CommonConfig.LINGERING_POTION_STACK_SIZE.get()));
        this.listener().finishCurrentTask(this.type());
    }

    @Override
    @NotNull
    public Type type() {
        return TYPE;
    }
}
