package Lesson5.Example3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ReverseServer {
    public static void main(String[] args) throws IOException {

        int port = 1236;

        // Server listening
        ServerSocket  serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port : "+port);


        // Waiting for client to connect
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");

        // Creating input and output stream
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Reading a string from a client
        String input = in.readLine();
        System.out.println("Received from client : "+input);

        // Reverse the string
        String reversed = new StringBuilder(input).reverse().toString();

        // Sending back the reversed string
        out.println(reversed);

        // Close resources
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
