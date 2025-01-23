package Lesson5.Example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HelloClient {
    public static void main(String[] args) {

        // define the server's ipaddress/hostname and port number
        String hostname = "localhost";
        int portNumber = 1234;

        try {
            // We are trying to connect to the server using a hostname and a port
            Socket socket = new Socket(hostname,portNumber);
            System.out.println("Connected to the server!");

            // Getting input from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Reading the message from the server
            String message = in.readLine();
            System.out.println("Server says :"+message);

            // Close the connections
            in.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
