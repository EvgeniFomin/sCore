package EvgeniFomin.sCore.netty.codec;

import EvgeniFomin.sCore.netty.interfaces.Packet;
import EvgeniFomin.sCore.netty.protocol.ConnectionState;
import EvgeniFomin.sCore.netty.protocol.PacketBuffer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

import static EvgeniFomin.sCore.Core.принятых;

public class Decoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {
        принятых++;
        if (buf.readableBytes() != 0) {
            PacketBuffer packetBuffer = new PacketBuffer(buf);
            int id = packetBuffer.readVarInt();
            Packet packet = ConnectionState.getPacket(id);
            if (packet != null) {
                packet.readPacketData(packetBuffer);
            }
            out.add(packet);
        }
    }
}

