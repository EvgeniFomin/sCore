package EvgeniFomin.sCore.netty.channels;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class Channels {
    private static Channels channels;
    private ChannelGroup proxyConnected = new DefaultChannelGroup("Proxy-connected", GlobalEventExecutor.INSTANCE);
    private ChannelGroup serverConnected = new DefaultChannelGroup("server-connected", GlobalEventExecutor.INSTANCE);
    private ChannelGroup allConnected = new DefaultChannelGroup("all-connected", GlobalEventExecutor.INSTANCE);

    public static Channels getChannels() {
        if (channels == null) {
            channels = new Channels();
        }
        return channels;
    }

    public ChannelGroup getAllConnected() {
        return allConnected;
    }

    public ChannelGroup getServerConnected() {
        return serverConnected;
    }

    public ChannelGroup getProxyConnected() {
        return proxyConnected;
    }
}
