package EvgeniFomin.sCore;

import EvgeniFomin.sCore.netty.hadllers.NetHandlerPlayServer;
import EvgeniFomin.sCore.netty.hadllers.ServerInitializer;
import EvgeniFomin.sCore.other.Messages;
import EvgeniFomin.sCore.other.Error;
import EvgeniFomin.sCore.utils.logger.Logger;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import static EvgeniFomin.sCore.netty.protocol.ConnectionState.ids;
import static EvgeniFomin.sCore.utils.Padezh.padezh;
//Continuation of development

public class Server {

    private Channel channel;
    private int port;

    public Server(int port) {
        this.port = port;
        Logger.getLogger().message(Messages.STARTING_TO_PORT.replace("%port%", "" + port));
    }

    public void run() {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(workerGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new ServerInitializer(new NetHandlerPlayServer(this)));
            channel = bootstrap.bind(port).sync().channel();
            Logger.getLogger().message(Messages.LOADING_PACKETS);
            for (Class packet : ids.values()) {
                Logger.getLogger().message(Messages.SUCCESSFULLY_LOAD_PACKET.replace("%packet%", "" + packet.getTypeName()));
            }
            Logger.getLogger().message(Messages.PACKETS_AMOUNT.replace("%amount%", ids.values().size() + "").replace("%пакета%", padezh("пакет", "", "a", "ов", ids.values().size())));
            Logger.getLogger().message(Messages.THE_BOOK_IS_SUCCESSFULLY_STARTED);
        } catch (Exception e) {
            Logger.getLogger().message(Error.ERROR_2);
        }
    }

    public Channel getChannel() {
        return channel;
    }
}
