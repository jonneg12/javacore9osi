package ru.netology;

import java.io.*;
import java.net.*;

public class ClientClass {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 8090;

        try {
            InetAddress inetAddress = InetAddress.getByName(host);
            System.out.println(inetAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try (Socket clientSocket = new Socket(host, port) ;
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF8"));
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
            out.write("ClientClass" + "\r\n");
            out.write("Host: localhost" + "\r\n");
            out.write("\r\n");
            out.flush();

            System.out.println("Response: ");
            String response = in.readLine();
            System.out.println(response);


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
