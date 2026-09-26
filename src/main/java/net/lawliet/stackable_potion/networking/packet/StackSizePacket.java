package net.lawliet.stackable_potion.networking.packet;

import net.lawliet.stackable_potion.PotionStacks;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record StackSizePacket(int potionStackSize, int splashPotionStackSize, int lingeringPotionStackSize) implements CustomPacketPayload {
    public static final Type<StackSizePacket> TYPE = new Type<>(Identifier.fromNamespaceAndPath(PotionStacks.MODID, "stack_size_packet"));

    public static final StreamCodec<FriendlyByteBuf, StackSizePacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, StackSizePacket::potionStackSize,
            ByteBufCodecs.VAR_INT, StackSizePacket::splashPotionStackSize,
            ByteBufCodecs.VAR_INT, StackSizePacket::lingeringPotionStackSize,
            StackSizePacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
