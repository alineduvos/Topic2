package Lesson6.Threads.MultiThreadedApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 1234;

        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started on port : "+port);

            // continuously listen for new client connections
            while(true){
                System.out.println("Waiting for connection....");
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected : "+clientSocket);

                // Create and start a thread for each specific client
                ClientHandler handler = new ClientHandler(clientSocket);
                Thread clienThread = new Thread(handler);
                clienThread.start();
            }

        }catch (IOException e){
            System.out.println("Error starting server : "+e.getMessage());
        }

    }
}

// Handles client communication in a separate thread
class  ClientHandler implements Runnable{

    private Socket clientSocket;

    public ClientHandler(Socket socket){
        this.clientSocket = socket;
    }

    @Override
    public void run() {

        try {
            // building io streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // continuously read messages from the client
            String message; // message coming from input stream
            while((message=in.readLine())!=null){
                System.out.println("Received from the client ("+clientSocket+") : "+message);

                // echo message back to client
                out.println("Server echo : "+message);

                // process some output
                InputHandler handler = new InputHandler();
                String output = handler.processInput(message);
                // send back ouput
                // out.println(output);
            }

        } catch (IOException e) {
            System.out.println("Connection closed : "+clientSocket);
        }finally{
            try {
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class InputHandler {
    public String processInput(String s){
        // do something with this input
        return "";
    }
}