 
package SimplEcho2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

 
public class Client {
    private static final PrintWriter p = new PrintWriter(System.out);
    
    public static void main(String[] args) {
        
        String hostName = "localhost";
        int port = 1234;
        
        try(Socket socket = new Socket(hostName, port)){
             p.printf("Connected to server on port : %d", port);
             
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             
             out.println("Hello server!");
             out.println("Testing!");
             p.printf("Server replied : %s", in.readLine());
             
             
        }catch (Exception e){
             System.out.println("Error : "+e.getMessage());
        }
        
    }
    
}
