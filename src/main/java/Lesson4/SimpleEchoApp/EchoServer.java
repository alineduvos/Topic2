 
package Lesson4.SimpleEchoApp;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    
    public static void main(String[] args) {
        
        // the port number for the server to listen on
        int port = 1234;
        
        try{
            ServerSocket server = new ServerSocket(port);
            
            System.out.println("Server is listening on port : "+port);
            
            // Accept a single client connection 
            Socket client = server.accept();
            System.out.println("Client connected!");
            
            
            // Set up input to receive data from client
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            
            // read line from the client
            System.out.println("Received from client :"+in.readLine());
            
            server.close();
            client.close();
            
        }
        catch (IOException e){
            System.out.println("Error :"+e.getMessage());
        }
        
        
    }
}
