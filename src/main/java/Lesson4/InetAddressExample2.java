 
package Lesson4;

import java.net.*;

 
public class InetAddressExample2 {
    
    public static void main(String[] args) {
        
        try{
            // the is the address 
            InetAddress address = InetAddress.getByName("www.eduvos.com");
            
            // getting host name
            String hostName = address.getHostName();
            
            // getting host address
            String ip = address.getHostAddress();
            
            
            System.out.println("Hostname : "+hostName);
            System.out.println("IP Address :"+ip);
            
        }catch (UnknownHostException e){
            System.out.println("Error :"+e.getMessage());
        }
        
    }
}
