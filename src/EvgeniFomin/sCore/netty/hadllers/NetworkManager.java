package EvgeniFomin.sCore.netty.hadllers;

import EvgeniFomin.sCore.netty.interfaces.INetHandler;
import EvgeniFomin.sCore.netty.interfaces.Packet;
import EvgeniFomin.sCore.netty.protocol.ThreadQuickExitException;
import EvgeniFomin.sCore.other.Error;
import EvgeniFomin.sCore.other.Messages;
import EvgeniFomin.sCore.utils.logger.Logger;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


public class NetworkManager extends SimpleChannelInboundHandler<Packet<?>> {
    private INetHandler packetListener;

    NetworkManager(INetHandler handler) {
        packetListener = handler;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void channelRead0(ChannelHandlerContext channel, Packet<?> packet) {
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) {
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) {
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            ((Packet<INetHandler>) msg).processPacket(this.packetListener);
        } catch (ThreadQuickExitException e) {
            System.out.println(Error.ERROR_3);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        Logger.getLogger().message(Messages.GAP_OF_COMMUNICATION);
    }
}