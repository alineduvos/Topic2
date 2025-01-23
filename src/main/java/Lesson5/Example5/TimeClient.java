package Lesson5.Example5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) throws IOException {
        String hostname = "localhost";
        int port = 1238;

        Socket socket = new Socket(hostname,port);
        System.out.println("Connected to the server");
        
        
        // Building stream
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String timeFromServer = in.readLine();

        System.out.println(timeFromServer);
        
        // Close resources
        in.close();
        socket.close();
    }
}
