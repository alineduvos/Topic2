package Lesson6.Threads;

public class CountingTask {
    public static void main(String[] args) {

        // First thread will count from 1 to 5
        Thread task1 = new Thread(()->{
            for(int x=1; x<=5; x++){
                System.out.println("[Task 1] Count : "+x);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Second thread will count from 1 to 5
        Thread task2 = new Thread(()->{
            for(int x=1; x<=5; x++){
                System.out.println("[Task 2] Count : "+x);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        // Starting both tasks(threads) together
        task1.start();
        task2.start();

        // Main thread also prints something
        System.out.println("Main threads is done setting up threads!");
    }
}
