package ru.ifmo.rain.sokolov.helloudp;

import java.io.IOException;
import java.net.*;


public class HelloUDPClientStreams extends HelloUDPStreams {

    private final InetSocketAddress serverAddress;
    private DatagramPacket receivePacket;

    public HelloUDPClientStreams(InetAddress address, int port, DatagramSocket socket) throws SocketException {
        super(socket);
        this.serverAddress = new InetSocketAddress(address, port);
        this.receivePacket = createReceivePacket();
    }

    public void sendMessage(MessageHelper requestMsg) throws IOException {
        sendString(requestMsg.toString(), serverAddress);
    }

    @Override
    protected DatagramPacket getReceivePacket() {
        return receivePacket;
    }

    public void sendString(
            String requestMsg
    ) throws IOException {
        sendString(requestMsg, serverAddress);
    }
}