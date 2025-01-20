 
package Lesson4.SimpleEchoApp;
 
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        
        String hostname = "localhost"; // 127.0.0.1
        int port = 1234;
        
        
        try{
            Socket connection = new Socket(hostname,port);
            System.out.println("Connected to server!");
            
            // Set up output to send data to the server
            PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
            
            out.println("Hello from the client!");
            
        }catch (Exception e){
            System.out.println("Error :"+e.getMessage());
        }
        
    }
}
