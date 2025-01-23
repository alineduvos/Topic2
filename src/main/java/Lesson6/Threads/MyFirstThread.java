package Lesson6.Threads;

/*
        A thread is a lightweight subprocess which can be executed concurrently.
        Each thread has its own stack (local variables, method calls)
        Multithreading -  means to allow multiple parts of a program to run concurrently

        Two ways to create threads in java
        ------------------------------------
        1. Extend the Thread class and override the run() method
        2. Implement the Runnable interface
        3. We can use anonymous classes or lambda expressions
 */
public class MyFirstThread extends Thread{

    public void run(){
        // run our code here
        System.out.println("Hello from my first thread! Thread name : "+ Thread.currentThread());
    }

    public static void main(String[] args) {
        // create an instance of a thread
        MyFirstThread thread = new MyFirstThread();
        // start the thread (this will run the run() method)
        thread.start();

        System.out.println("Hello from the main thread - Thread name : " + Thread.currentThread());

    }
}
