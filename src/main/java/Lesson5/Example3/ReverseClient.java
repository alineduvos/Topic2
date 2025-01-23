package Lesson5.Example3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ReverseClient {
    public static void main(String[] args) throws IOException {
        String hostname = "localhost";
        int port = 1236;

        // Connect to the server
        Socket socket  = new Socket(hostname, port);
        System.out.println("Connected to the Server!");

        // Creating input and output stream
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Getting input from the console
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to reverse : ");
        String str = scanner.nextLine();

        // Sending string to be reversed to server
        out.println(str);

        // Read the reversed string from the server
        String reversed = in.readLine();
        System.out.println("Server returned :"+reversed);

        out.close();
        in.close();
        socket.close();

    }
}
