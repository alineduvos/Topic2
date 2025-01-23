package Lesson6.Threads.MultiThreadedApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        try(Socket socket = new Socket(host, port)){
            // building i/o streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            // reading input from console
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Connected to the server at :"+host+" : "+port);


            // a thread to listen for server messages
            Thread serverListener = new Thread(()->{
               try{
                   String serverResponse;
                   while((serverResponse=in.readLine())!=null){
                       System.out.println(serverResponse);
                   }
               }catch (IOException e){
                   System.out.println("Error : "+e.getMessage());
               }
            });
            serverListener.start();

            // main thread : read user input and send to server
            String userMessage;
            while((userMessage=userInput.readLine())!=null){
                out.println(userMessage);
                if(userMessage.equals("exit")){
                    System.out.println("quitting....");
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error : "+e.getMessage());
        }
    }
}
