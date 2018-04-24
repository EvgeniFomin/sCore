package EvgeniFomin.sCore.netty.interfaces;

import EvgeniFomin.sCore.netty.packet.*;

public interface INetHandlerPlayServer extends INetHandler {
    void onHandshake(Handshake_Packet handshake_packet);

    void onPlayerJoin(PlayerJoinProxy_Packet playerJoinProxy_packet);

    void onPlayerQuit(PlayerQuitProxy_Packet playerQuitProxy_packet);

    void onProxyConnect(ProxyConnect_Packet proxyConnect_packet);

    void onOnlineCollector(OnlineCollector_Packet onlineCollector_packet);
}