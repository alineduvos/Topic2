package Lesson6.URL;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class URLExample2 {
    public static void main(String[] args) throws IOException {
        String videoURL = "https://test-videos.co.uk/vids/bigbuckbunny/mp4/h264/1080/Big_Buck_Bunny_1080_10s_1MB.mp4";
        String destination = "mydownload.mp4";

        URL url = new URL(videoURL);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Video downloaded!");

    }
}
