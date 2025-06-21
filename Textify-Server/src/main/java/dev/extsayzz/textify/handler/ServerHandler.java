package dev.extsayzz.textify.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class ServerHandler extends SimpleChannelInboundHandler<HttpObject> {


    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) {
        if (httpObject instanceof HttpRequest) {
            FullHttpResponse response = new DefaultFullHttpResponse(
                    HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                    Unpooled.copiedBuffer("Hello, World!", CharsetUtil.UTF_8)
            );
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, String.valueOf(response.content().readableBytes()));
            channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        }
    }
}
