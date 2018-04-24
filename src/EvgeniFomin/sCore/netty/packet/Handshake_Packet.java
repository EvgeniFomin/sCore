package EvgeniFomin.sCore.netty.packet;

import EvgeniFomin.sCore.netty.interfaces.INetHandlerPlayServer;
import EvgeniFomin.sCore.netty.interfaces.Packet;
import EvgeniFomin.sCore.netty.protocol.ConnectionState;
import EvgeniFomin.sCore.netty.protocol.PacketBuffer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Handshake_Packet implements Packet<INetHandlerPlayServer> {

    @Override
    public void readPacketData(PacketBuffer buf) {}

    @Override
    public void writePacketData(PacketBuffer buf) {
        buf.writeVarInt(ConnectionState.getPacketId(this));
    }

    @Override
    public void processPacket(INetHandlerPlayServer handler) {
        handler.onHandshake(this);
    }
}
