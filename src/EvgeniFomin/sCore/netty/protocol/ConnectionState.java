package EvgeniFomin.sCore.netty.protocol;

import EvgeniFomin.sCore.netty.interfaces.Packet;
import EvgeniFomin.sCore.netty.packet.Handshake_Packet;
import EvgeniFomin.sCore.netty.packet.PlayerJoinProxy_Packet;
import EvgeniFomin.sCore.netty.packet.PlayerQuitProxy_Packet;

import java.util.HashMap;
import java.util.Map;

public class ConnectionState {
    public static Map<Integer, Class<? extends Packet>> ids = new HashMap<Integer, Class<? extends Packet>>();

    static {
        ids.put(1, Handshake_Packet.class);
        ids.put(2, PlayerJoinProxy_Packet.class);
        ids.put(3, PlayerQuitProxy_Packet.class);
    }

    public static int getPacketId(Packet packet) {
        Map<Class<? extends Packet>, Integer> inverse = new HashMap<Class<? extends Packet>, Integer>();
        for (Integer id : ids.keySet()) {
            inverse.put(ids.get(id), id);
        }
        return inverse.get(packet.getClass());
    }

    public static Packet getPacket(int i) throws InstantiationException, IllegalAccessException {
        Class<? extends Packet> aClass = ids.get(i);
        return aClass == null ? null : aClass.newInstance();
    }
}