package com.halo.framework.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpChannel;

/**
 * Created by muxi on 2016/10/21.
 */
public class nettyBootstrap {

    public static void mian(String[] args) {



        EventLoopGroup group = new NioEventLoopGroup(1);
        Bootstrap b = new Bootstrap();
        b.group(group).channel(NioSctpChannel.class);
    }
}
