package com.borislavmm;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    try {

            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket datagramSocket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            String echoString;

            do {

                System.out.println("Enter String to be echoed: ");
                echoString = scanner.nextLine();

                byte[] buffer = echoString.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                datagramSocket.send(packet);


                //printing part
                byte[] receiveBuffer = new byte[50];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                datagramSocket.receive(receivePacket);

                System.out.println(new String(receivePacket.getData()));

            }while (!echoString.equals("exit"));



        }catch (SocketTimeoutException e) {
	        e.printStackTrace();
        }catch (IOException e) {
	        e.printStackTrace();
        }
    }
}
