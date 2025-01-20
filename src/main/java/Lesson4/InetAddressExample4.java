 
package Lesson4;

import java.io.IOException;
import java.net.*;
 
public class InetAddressExample4 {
    
    public static void main(String[] args) {
        
        try{
            
            InetAddress address = InetAddress.getByName("www.google.com");
            
            // checking if address is reachable 
            boolean reachable = address.isReachable(3000);
            
            if(reachable){
                System.out.println(address.getHostName() + " is online and reachable!");
            }else{
                System.out.println(address.getHostName() + " is offline and not reachable!");
            }
            
        }catch (UnknownHostException e){
            System.out.println("Host could not be found");
        }catch (IOException ex){
            System.out.println("Error occurred during reachablity check");
        }
        
    }
}
