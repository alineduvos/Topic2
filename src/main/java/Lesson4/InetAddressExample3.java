 
package Lesson4;

import java.net.*; 

public class InetAddressExample3 {
    public static void main(String[] args) {
        
        try{
        
            String domainName = "www.design.com";
            InetAddress addresses[] = InetAddress.getAllByName(domainName);
            
            for(InetAddress address : addresses){
                System.out.println("IP :"+address.getHostAddress());
            }
            
        }catch (UnknownHostException e){
            System.out.println("Error :"+e.getMessage());
        }
            
        
    }
}
