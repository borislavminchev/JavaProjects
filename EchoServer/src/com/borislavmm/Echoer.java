package com.borislavmm;

import java.io.*;
import java.net.Socket;

public class Echoer extends Thread {

    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Client entered");
        try {

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                String echoString = input.readLine();
                System.out.println("Received client input: " + echoString);
                if (echoString.equals("exit")) {
                    break;
                }


                output.println(echoString);
            }


        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
