package dev.extsayzz.textify.chat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws Exception {
        final EventLoopGroup group = new NioEventLoopGroup();

        try {
            final Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChatClientInitializer());

            final Channel channel = bootstrap.connect("localhost", 8080).sync().channel();
            System.out.println("Connected to the server.");

            final Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
                channel.writeAndFlush(message);
            }
        } finally {
            group.shutdownGracefully();
        }
    }
}

class ChatClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    public void initChannel(SocketChannel socketChannel) {
        final ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new StringDecoder(), new StringEncoder());
        pipeline.addLast(new ChatClientHandler());
    }
}

class ChatClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, String message) {
        System.out.println("New message: " + message);
    }
}
