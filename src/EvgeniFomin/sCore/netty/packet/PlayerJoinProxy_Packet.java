package EvgeniFomin.sCore.netty.packet;

import EvgeniFomin.sCore.netty.channels.Servers;
import EvgeniFomin.sCore.netty.interfaces.INetHandlerPlayServer;
import EvgeniFomin.sCore.netty.interfaces.Packet;
import EvgeniFomin.sCore.netty.protocol.ConnectionState;
import EvgeniFomin.sCore.netty.protocol.PacketBuffer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlayerJoinProxy_Packet implements Packet<INetHandlerPlayServer> {
    private String player;
    private String proxy;

    public static void send(Channel channel, Packet<?> packet, String player, String proxy) throws IOException {
        ByteBuf buf = Unpooled.buffer();
        PacketBuffer packetBuffer = new PacketBuffer(buf);
        packetBuffer.writeString(player);
        packetBuffer.writeString(proxy);
        packet.readPacketData(packetBuffer);
        channel.writeAndFlush(packet);
    }

    public static void sendAll(Packet<?> packet, String player, String proxy) throws IOException {
        ByteBuf buf = Unpooled.buffer();
        PacketBuffer packetBuffer = new PacketBuffer(buf);
        packetBuffer.writeString(player);
        packetBuffer.writeString(proxy);
        packet.readPacketData(packetBuffer);
        for (Channel channel : Servers.getServersManager().getProxy().values()){
            channel.writeAndFlush(packet);
        }
    }

    @Override
    public void readPacketData(PacketBuffer buf) {
        this.player = buf.readString(256);
        this.proxy = buf.readString(256);
    }

    @Override
    public void writePacketData(PacketBuffer buf) {
        buf.writeVarInt(ConnectionState.getPacketId(this));
        buf.writeString(this.player);
        buf.writeString(this.proxy);
    }

    @Override
    public void processPacket(INetHandlerPlayServer handler) {
        handler.onPlayerJoin(this);
    }

    public String getName() {
        return this.player;
    }

    public String getProxy() {
        return this.proxy;
    }
}
