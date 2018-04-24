package EvgeniFomin.sCore.netty.codec;

import EvgeniFomin.sCore.netty.interfaces.Packet;
import EvgeniFomin.sCore.netty.protocol.PacketBuffer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import static EvgeniFomin.sCore.Core.исходящих;

public class Encoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf buf) throws Exception {
        исходящих++;
        PacketBuffer packetBuffer = new PacketBuffer(buf);
        packet.writePacketData(packetBuffer);
    }
}
