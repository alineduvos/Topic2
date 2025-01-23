package Lesson5.Example2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {

        int port = 1234;

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server listening : ["+port+"]");

        Socket clienSocket = serverSocket.accept();
        System.out.println("Server status : client connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clienSocket.getOutputStream(), true);

        String clientMessage = in.readLine();
        System.out.println("Received from client :"+clientMessage);
        out.println("Server echoes :"+clientMessage);

        in.close();
        out.close();
        clienSocket.close();
        serverSocket.close();
    }
}
