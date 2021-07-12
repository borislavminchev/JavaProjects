package com.borislavmm;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MyUDPServer extends Thread {

    private DatagramSocket socket;
    private static int numClients = 0;

    public MyUDPServer(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                numClients++;
                if (numClients == 7 || numClients == 0) {
                    break;
                }
                byte[] buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String recievedstring = new String(buffer, 0, packet.getLength());
                if (recievedstring.equals("exit")){
                    numClients--;
                }
                System.out.println("Received message: " + recievedstring + " from " + packet.getAddress());
                byte[] buffer2 = ("You typed: " + recievedstring).getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buffer2, buffer2.length, address, port);
                socket.send(packet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
