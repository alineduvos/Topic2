package Example1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
    TCP Client / Server Basic Structure
    1 - Build a server
    2 - Build our client

    1 - Server
    2 - Protocol / Handler
    3 - Client


 */
public class HelloServer {

    public static void main(String[] args) {

         int portNumber = 1234;


        try {
            // ServerSocket class is used by our server to listen for incoming
            // client connection on our port number
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server is listening on port "+portNumber);

            // Server waits here until a client tries to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Sending a "hello" message to the client
            out.println("Hello from the Serve!");

            out.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
