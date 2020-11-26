package ru.netology;

import java.io.*;
import java.net.*;

public class ServerClass {

    public static void main(String[] args) {
        int port = 8090;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("New connection accepted!");
            final String name = in.readLine();

            System.out.println("Start sending ***");
            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            System.out.println("Stop sending ***");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

