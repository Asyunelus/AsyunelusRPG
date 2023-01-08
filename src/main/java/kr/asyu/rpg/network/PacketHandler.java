package kr.asyu.rpg.network;

import kr.asyu.rpg.AsyunelusRPG;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler {
    private static final String PROTOCOL_VERSION = "v1.0.1";
    public static final SimpleChannel channel = NetworkRegistry.newSimpleChannel(
        AsyunelusRPG.getId("main"),
        () -> PROTOCOL_VERSION,
        PROTOCOL_VERSION::equals,
        PROTOCOL_VERSION::equals
    );

    public static void initialize() {
        int packetID = 0;
    }

    public static <MSG> void sendToServer(MSG message) {
        channel.sendToServer(message);
    }

    public static <MSG> void send(PacketDistributor.PacketTarget target, MSG message) {
        channel.send(target, message);
    }

    public static <MSG> void send(Player player, MSG message) {
        channel.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) player), message);
    }
}