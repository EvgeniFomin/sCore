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
public class ProxyConnect_Packet implements Packet<INetHandlerPlayServer> {
    private String name;
    private String host;
    private Integer port;

    public static void send(Channel channel, Packet<?> packet, String name, String host, Integer port) throws IOException {
        ByteBuf buf = Unpooled.buffer();
        PacketBuffer packetBuffer = new PacketBuffer(buf);
        packetBuffer.writeString(name);
        packetBuffer.writeString(host);
        packetBuffer.writeInt(port);
        packet.readPacketData(packetBuffer);
        channel.writeAndFlush(packet);
    }

    public static void sendAll(Packet<?> packet, String name, String host, Integer port) throws IOException {
        ByteBuf buf = Unpooled.buffer();
        PacketBuffer packetBuffer = new PacketBuffer(buf);
        packetBuffer.writeString(name);
        packetBuffer.writeString(host);
        packetBuffer.writeInt(port);
        packet.readPacketData(packetBuffer);
        for (Channel channel : Servers.getServersManager().getProxy().values()) {
            channel.writeAndFlush(packet);
        }
    }

    @Override
    public void readPacketData(PacketBuffer buf) {
        this.name = buf.readString(256);
        this.host = buf.readString(256);
        this.port = buf.readInt();
    }

    @Override
    public void writePacketData(PacketBuffer buf) {
        buf.writeVarInt(ConnectionState.getPacketId(this));
        buf.writeString(this.name);
        buf.writeString(this.host);
        buf.writeInt(this.port);
    }

    @Override
    public void processPacket(INetHandlerPlayServer handler) {
        handler.onProxyConnect(this);
    }

    public String getName() {
        return this.name;
    }

    public String getHost() {
        return this.host;
    }

    public Integer getPort() {
        return this.port;
    }


}
