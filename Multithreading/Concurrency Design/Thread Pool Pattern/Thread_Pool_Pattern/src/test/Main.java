package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	// Maximum number of threads in thread pool.
	static final int MAX_T = 5;
	
	public static void main(String[] args) {
		// Creates five tasks.
		Runnable r1 = new Task("Task 1");
		Runnable r2 = new Task("Task 2");
		Runnable r3 = new Task("Task 3");
		Runnable r4 = new Task("Task 4");
		Runnable r5 = new Task("Task 5");
		Runnable r6 = new Task("Task 6");
		Runnable r7 = new Task("Task 7");
		Runnable r8 = new Task("Task 8");
		
		// Creates a thread pool with MAX_T number of thread as the fixed pool size.
		ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
		
		// Passes the Task objects to the pool to execute.
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		pool.execute(r6);
		pool.execute(r7);
		pool.execute(r8);
		
		// Shutdowns the pool.
		pool.shutdown();
		
		System.out.println("Main thread - Done.\n");
	}

}
