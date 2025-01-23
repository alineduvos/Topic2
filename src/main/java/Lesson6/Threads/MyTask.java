package Lesson6.Threads;

public class MyTask implements Runnable{

    @Override
    public void run() {
        System.out.println("This task is running! Thread name :"+Thread.currentThread());
    }


    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Hello from the main thread!");
    }
}
