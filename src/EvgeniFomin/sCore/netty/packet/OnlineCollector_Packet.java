package EvgeniFomin.sCore.netty.packet;

import EvgeniFomin.sCore.netty.channels.Servers;
import EvgeniFomin.sCore.netty.interfaces.INetHandlerPlayServer;
import EvgeniFomin.sCore.netty.interfaces.Packet;
import EvgeniFomin.sCore.netty.protocol.ConnectionState;
import EvgeniFomin.sCore.netty.protocol.PacketBuffer;
import EvgeniFomin.sCore.utils.nbt.NBTTagCompound;
import EvgeniFomin.sCore.utils.nbt.NBTTagList;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static EvgeniFomin.sCore.utils.nbt.NBTUtil.toArrayList;
import static EvgeniFomin.sCore.utils.nbt.NBTUtil.toNBTTagList;

public class OnlineCollector_Packet implements Packet<INetHandlerPlayServer> {
    List<String> online = new ArrayList<String>();

    public static void send(Channel channel, Packet<?> packet, ArrayList<String> online) throws IOException {
        ByteBuf buf = Unpooled.buffer();
        PacketBuffer packetBuffer = new PacketBuffer(buf);
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("online", toNBTTagList(online));
        packetBuffer.writeCompoundTag(nbt);
        packet.readPacketData(packetBuffer);
        channel.writeAndFlush(packet);
    }

    public static void sendAll(Packet<?> packet, ArrayList<String> online) throws IOException {
        ByteBuf buf = Unpooled.buffer();
        PacketBuffer packetBuffer = new PacketBuffer(buf);
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("online", toNBTTagList(online));
        packetBuffer.writeCompoundTag(nbt);
        packet.readPacketData(packetBuffer);
        for (Channel channel : Servers.getServersManager().getProxy().values()) {
            channel.writeAndFlush(packet);
        }
    }

    @Override
    public void readPacketData(PacketBuffer buf) {
        NBTTagCompound nbt = new NBTTagCompound();
        try {
            nbt.setTag("online", buf.readCompoundTag());
        } catch (IOException e) {
            e.printStackTrace();
        }
        NBTTagList list = (NBTTagList) nbt.getTag("list");
        online = toArrayList(list);
    }

    public List<String> getPlayers() {
        return online;
    }

    @Override
    public void writePacketData(PacketBuffer buf) {
        buf.writeVarInt(ConnectionState.getPacketId(this));
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("online", toNBTTagList(online));
        buf.writeCompoundTag(nbt);
    }

    @Override
    public void processPacket(INetHandlerPlayServer handler) {
        handler.onOnlineCollector(this);
    }
}
