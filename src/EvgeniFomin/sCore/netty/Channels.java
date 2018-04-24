//package EvgeniFomin.score.netty;
//
//import io.netty.channel.Channel;
//import io.netty.channel.group.ChannelGroup;
//import io.netty.channel.group.DefaultChannelGroup;
//import io.netty.util.concurrent.GlobalEventExecutor;
//
//import java.util.HashMap;
//
//public class Channels {
//    private static Channels channels;
//    private ChannelGroup proxyConnected = new DefaultChannelGroup("Proxy-connected", GlobalEventExecutor.INSTANCE);
//    private ChannelGroup serverConnected = new DefaultChannelGroup("server-connected", GlobalEventExecutor.INSTANCE);
//    private ChannelGroup allConnected = new DefaultChannelGroup("all-connected", GlobalEventExecutor.INSTANCE);
//    private HashMap<String, Channel> proxyChannels = new HashMap();
//    private HashMap<String, Channel> serverChannels = new HashMap();
//
//    public static Channels getChannels() {
//        if (channels == null) {
//            channels = new Channels();
//        }
//        return channels;
//    }
//
//    public ChannelGroup getAllConnected() {
//        return allConnected;
//    }
//
//    public ChannelGroup getProxyConnected() {
//        return proxyConnected;
//    }
//
//    public ChannelGroup getServerConnected() {
//        return serverConnected;
//    }
//
//    public HashMap<String, Channel> getProxyChannels() {
//        return proxyChannels;
//    }
//
//    public HashMap<String, Channel> getServerChannels() {
//        return serverChannels;
//    }
//
//    public Channel getProxyChannel(String name) {
//        return proxyChannels.get(name);
//    }
//
//    public Channel getServerChannel(String name) {
//        return serverChannels.get(name);
//    }
//
//    public void addProxy(String proxyName, Channel channel) {
//        proxyChannels.put(proxyName, channel);
//    }
//
//    public void removeProxy(String proxyName) {
//        proxyChannels.remove(proxyName);
//    }
//
//    public void addServer(String serverName, Channel channel) {
//        serverChannels.put(serverName, channel);
//    }
//
//    public void removeServer(String serverName) {
//        serverChannels.remove(serverName);
//    }
//}
