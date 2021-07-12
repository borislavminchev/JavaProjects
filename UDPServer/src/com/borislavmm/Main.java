package com.borislavmm;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;

public class Main {

    public static void main(String[] args) {
	    try {
	        new MyUDPServer(new DatagramSocket(5000)).start();

        }catch (SocketException e) {
	        e.printStackTrace();
        }
    }
}
