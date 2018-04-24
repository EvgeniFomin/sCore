package EvgeniFomin.sCore.netty.hadllers;

import EvgeniFomin.sCore.netty.codec.Decoder;
import EvgeniFomin.sCore.netty.codec.Encoder;
import EvgeniFomin.sCore.netty.interfaces.INetHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    private INetHandler packetListener;

    public ServerInitializer(INetHandler handler) {
        this.packetListener = handler;
    }

    @Override
    protected void initChannel(SocketChannel channel) {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast("decoder", new Decoder());
        pipeline.addLast("encoder", new Encoder());
        pipeline.addLast("handler", new NetworkManager(packetListener));
    }
}