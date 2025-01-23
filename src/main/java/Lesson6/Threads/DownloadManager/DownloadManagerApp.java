package Lesson6.Threads.DownloadManager;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalTime;

public class DownloadManagerApp {
    /*
        1 - Display current time after every 2 second
        2 - Download an image
        3 - Download a video
     */

    public static void main(String[] args) {

        // 1. A task that displays current time every 2 seconds
        Thread task1 = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("Current time : "+ LocalTime.now());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Time-Task" );


        // 2. A task to download an image in the background
        Thread task2 = new Thread(()->{
            String imageUrl = "https://en.wikipedia.org/wiki/Batman#/media/File:Batman_Infobox.jpg";
            String destinationFile = "myimage.jpg";
            System.out.println("Starting image download from : "+imageUrl);

            try {
                InputStream in = new URL(imageUrl).openStream();
                // Copy the file from input stream to local destination
                Files.copy(in, Paths.get(destinationFile), StandardCopyOption.REPLACE_EXISTING);

                System.out.println("Imaged downloaded to : "+destinationFile);

            } catch (IOException e) {
                System.out.println("Failed to download image: "+e.getMessage());
            }

        },"Image-Download-Task");

        // Running our tasks side by side
        task1.start();
        task2.start();

        // a condition to interrupt a task
        task1.interrupt();

    }
}
