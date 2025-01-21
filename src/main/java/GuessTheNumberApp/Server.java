package GuessTheNumberApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        int portNumber = 5000;

        // Listening
        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("Server is listening on port "+portNumber);

        // Accepting client (single client)
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        // Building IO streams
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        // Creating an instance of our handler class
        Handler handler = new Handler();

        // Since the server drives the conversation (we sending something empty)
        String outputLine = handler.processInput("");
        out.println(outputLine);


        // Closing resources
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
        System.out.println("Server shut down");
    }

}
