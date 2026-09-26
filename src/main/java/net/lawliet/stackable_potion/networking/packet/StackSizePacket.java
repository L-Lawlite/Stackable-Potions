package net.lawliet.stackable_potion.networking.packet;

import net.lawliet.stackable_potion.PotionStacks;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record StackSizePacket(String name,int stackSize) implements CustomPacketPayload {
    public static final Type<StackSizePacket> TYPE = new Type<>(Identifier.fromNamespaceAndPath(PotionStacks.MODID, "stack_size_packet"));

    public static final StreamCodec<FriendlyByteBuf, StackSizePacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, StackSizePacket::name,
            ByteBufCodecs.VAR_INT, StackSizePacket::stackSize,
            StackSizePacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
