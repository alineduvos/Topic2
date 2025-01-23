package Lesson5.Example5;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeServer {
    public static void main(String[] args) throws IOException {

        int port = 1238;

        // Listening
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server listening on port : "+port);

        // Accepting client
        Socket clientSocket =serverSocket.accept();
        System.out.println("Client connected");

        // Building stream
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);

        // Getting current time
        LocalDateTime now = LocalDateTime.now();
        String timeString = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        // Send time back
        out.println("Current server time is :"+timeString);

        // Close
        out.close();
        clientSocket.close();
        serverSocket.close();

    }
}
