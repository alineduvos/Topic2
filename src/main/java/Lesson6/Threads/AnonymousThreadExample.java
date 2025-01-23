package Lesson6.Threads;

public class AnonymousThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // task
                System.out.println("Doing some task!");
            }
        });

        thread.start();
        System.out.println("main thread finished!");
    }
}
