package Lesson5.Example4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
    public static void main(String[] args) throws IOException {

        int port = 1237;

        // Listen on port 1237
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is running on port : "+port);

        // Accept client
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        // Building io streams
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);

        // Read the expression sent by the client

        // 2 + 3
        String expression = in.readLine();
        System.out.println("Received expression : "+expression);

        // splitting expression into parts (number operator number)
        String parts [] = expression.split(" ");
        double result = 0;

        // basic validation (parts[0] parts[1] parts[2])
        if(parts.length==3){
            double num1 = Double.parseDouble(parts[0]);
            String operator = parts[1];
            double num2 = Double.parseDouble(parts[2]);

            switch (operator){
                case "+":
                        result = num1+num2;
                        break;
                case "-":
                        result = num1-num2;
                        break;
                case "*":
                        result = num1*num2;
                        break;
                case "/":
                        if(num2!=0){
                            result = num1/num2;
                        }else{
                            out.println("Error : cannot divide by 0");
                            in.close();
                            out.close();
                            clientSocket.close();
                            serverSocket.close();
                        }
                        break;
                default:
                    out.println("Error : unknown operator");
                    out.println("Error : cannot divide by 0");
                    in.close();
                    out.close();
                    clientSocket.close();
                    serverSocket.close();
            }

            out.println("Result : "+result);
        }else{
            out.println("Error : Invalid format. Use this format -> number operator number (e.g., 3 + 1)");
        }

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
