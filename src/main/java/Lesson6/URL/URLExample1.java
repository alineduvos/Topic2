package Lesson6.URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
     URL = Uniform Resource Locator.
 */
public class URLExample1 {
    public static void main(String[] args) throws IOException {

        String urlString= "https://www.cnn.com";

        // create a url object
        URL url = new URL(urlString);

        // print url components
        System.out.println("Protocol : "+url.getProtocol());
        System.out.println("Host : "+url.getHost());
        System.out.println("Port : "+url.getPort());
        System.out.println("Path : "+url.getPath());
        System.out.println("Query : "+url.getQuery());
        System.out.println("Ref : "+url.getRef());


        // open a stream to url object and read content
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        System.out.println("\n --- Content Start ---");
        while((line=reader.readLine())!=null){
            System.out.println(line);
        }
        System.out.println("--- Content End ---");
    }
}
