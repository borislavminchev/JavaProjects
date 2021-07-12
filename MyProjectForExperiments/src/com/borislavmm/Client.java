package com.borislavmm;

import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        while (true) {
            try (Socket socket = new Socket("localhost", 8765)) {
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                String enterStr;
                String outStr;
                do {
                    enterStr = new Scanner(System.in).next();
                    output.println(enterStr);

                    if (!enterStr.equals("exit")) {
                        outStr = input.readLine();
                        System.out.println(outStr);
                    }
                } while (!enterStr.equals("exit"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
