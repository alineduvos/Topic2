package Example4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {

    public static void main(String[] args) throws IOException {

        String hostname = "localhost";
        int port = 1237;

        // Connect to server
        Socket socket = new Socket(hostname, port);
        System.out.println("Connected to the server!");

        // Building io streams
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Getting input from the console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an expression in the format : number operator number (e.g., 3 + 1)");
        String expression = scanner.nextLine();

        // Sending the expression to the server
        out.println(expression);

        // Reading response from server
        String response = in.readLine();
        System.out.println("Server says : "+response);

        // Closing resources
        scanner.close();
        in.close();
        out.close();
        socket.close();
    }
}
