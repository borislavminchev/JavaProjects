package com.borislavmm;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {

    public static void main(String[] args) {
	    try(ServerSocket socket = new ServerSocket(8765)){

	        while (true) {
                Socket client = socket.accept();
	            MyServer myServer = new MyServer(client);
                MyServer.clients.add(client);
	            new Thread(myServer).start();
            }
        }catch (IOException e) {
	        e.printStackTrace();
        }
    }
}

class MyServer extends Thread {
    private Socket socket;
    public static List<Socket> clients;

    public MyServer(Socket socket) {
        this.socket = socket;
        clients = new ArrayList<>();
    }


    @Override
    public void run() {
        try {
            System.out.println("Client connected");


            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            while(true) {
                String line = input.readLine();

                if (line.equals("exit")){
                    break;
                }
                double number = Double.parseDouble(line.replace(',', '.'));
                if (number == 3) {



                } else {

                    output.println( "Server returns: " + (Math.pow(number, 2)));
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}