package EvgeniFomin.sCore.netty.hadllers;

import EvgeniFomin.sCore.Server;
import EvgeniFomin.sCore.netty.interfaces.INetHandlerPlayServer;
import EvgeniFomin.sCore.netty.packet.*;
import EvgeniFomin.sCore.other.Messages;
import EvgeniFomin.sCore.utils.logger.Logger;
import io.netty.channel.Channel;

public class NetHandlerPlayServer implements INetHandlerPlayServer {

    private Server server;
    private Channel channel;

    public NetHandlerPlayServer(Server server) {
        this.server = server;
        this.channel = server.getChannel();
    }

    @Override
    public void onHandshake(Handshake_Packet handshake_packet) {
        Logger.getLogger().message(Messages.RECEIVING_PACKET.replace("%packet%", "handshake_packet"));
    }

    @Override
    public void onPlayerJoin(PlayerJoinProxy_Packet playerJoinProxy_packet) {
        Logger.getLogger().message(Messages.RECEIVING_PACKET.replace("%packet%", "playerJoinProxy_packet"));
        Logger.getLogger().message(Messages.JOIN_PLAYER.replace("%player%", playerJoinProxy_packet.getName()));
    }

    @Override
    public void onPlayerQuit(PlayerQuitProxy_Packet playerQuitProxy_packet) {
        Logger.getLogger().message(Messages.RECEIVING_PACKET.replace("%packet%", "playerQuitProxy_packet"));
        Logger.getLogger().message(Messages.QUIT_PLAYER.replace("%player%", playerQuitProxy_packet.getName()));
    }

    @Override
    public void onProxyConnect(ProxyConnect_Packet proxyConnect_packet) {
        Logger.getLogger().message(Messages.RECEIVING_PACKET.replace("%packet%", "proxyConnect_packet"));
    }

    @Override
    public void onOnlineCollector(OnlineCollector_Packet onlineCollector_packet) {
        Logger.getLogger().message(Messages.RECEIVING_PACKET.replace("%packet%", "onlineCollector_packet"));
        System.out.println(onlineCollector_packet.getPlayers());
    }
}