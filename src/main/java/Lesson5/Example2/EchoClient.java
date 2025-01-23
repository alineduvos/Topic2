package Lesson5.Example2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws IOException {

        String hostname = "localhost";
        int port = 1234;

        Socket socket = new Socket(hostname, port);
        System.out.println("Client status : connected to server");

        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println(" We like Java! ");
        String response = in.readLine();
        System.out.println("Server responded : "+response);

        out.close();
        socket.close();
    }
}
