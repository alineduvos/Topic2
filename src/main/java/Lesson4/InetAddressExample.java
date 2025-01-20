 
package Lesson4;

import java.net.InetAddress;
import java.net.UnknownHostException;

 
public class InetAddressExample {
    public static void main(String[] args) {
        
        try{
            // We just getting the ip addres using a domain name
            InetAddress address = InetAddress.getByName("www.google.com");
            
            System.out.println("IP Address: "+address.getHostAddress());
            
        }catch (UnknownHostException e ){
            e.printStackTrace();
        }
        
    }
}
