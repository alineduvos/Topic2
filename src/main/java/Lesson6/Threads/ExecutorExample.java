package Lesson6.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {

        ExecutorService exector = Executors.newFixedThreadPool(3);

        // task 1
        Runnable task1 = ()->{
            for(int x=1; x<=3; x++){
                System.out.println("Task-1 running:"+x);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };


        // task 2
        Runnable task2 = ()->{
            for(int x=1; x<=3; x++){
                System.out.println("Task-2 running:"+x);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };


        // task 3
        Runnable task3 = ()->{
            for(int x=1; x<=3; x++){
                System.out.println("Task-3 running:"+x);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        // submitting the tasks to be scheduled for execution
        exector.execute(task1);
        exector.execute(task2);
        exector.execute(task3);

        // just stopping and new tasks from being executed
        exector.shutdown();

    }
}
