 
package SimplEcho2;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    
    private static final int PORT = 1234;
    private static final PrintWriter p = new PrintWriter(System.out);
    
    public static void main(String[] args) {
        
        try(ServerSocket serverSocket = new ServerSocket(PORT)){ 
            p.printf("Server listening on port : %d", PORT);
            
            Socket clientSocket = serverSocket.accept();
            p.printf("Client connected : %s", clientSocket.getLocalAddress());
            
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            p.printf("Received Message : %s",in.readLine());
            out.println("We got your message!");
            
            // closing client socket
            clientSocket.close();
            
        }catch (Exception e){
            System.out.println("Error : "+e.getMessage());
        }
    }
}
