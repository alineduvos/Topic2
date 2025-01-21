package GuessTheNumberApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String hostname = "localhost";
        int portNumber = 5000;

        // Connecting to Server
        Socket socket = new Socket(hostname,portNumber);

        // Building IO Streams
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Reading from console
        Scanner userInput = new Scanner(System.in);

        // Reading initial server response (welcome message)
        String serverResponse = in.readLine();
        System.out.println(serverResponse);

        // Keep sending user input to the server
        while(true){

            // Asking usr for input
            System.out.print("Your input : ");
            String userGuess = userInput.nextLine();

            // Send the guess to the server
            out.println(userGuess);

            // Read server response
            serverResponse = in.readLine();
            if(serverResponse==null){
                // Server closed the connection
                System.out.println("Server disconnected. Exiting!");
                break;
            }

            // Display server's response
            System.out.println(serverResponse);

            // If server's response is goodbye then close client
            if(serverResponse.contains("goodbye")){
                break;
            }
        }

        // Close resources
        userInput.close();
        in.close();
        out.close();
        socket.close();
        System.out.println("Client closed");

    }
}
