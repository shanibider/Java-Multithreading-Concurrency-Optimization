package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyGenericActiveObject {
	// Data members:
	private BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(100);
	private Thread thread;
	private volatile boolean isRunning = true;
	
	// CTOR.
	public MyGenericActiveObject() {
		this.thread = new Thread(() -> {
							while(this.isRunning == true) {
								try {
									this.blockingQueue.take().run();
								} catch (InterruptedException e) { e.printStackTrace();	}
						 }
		});
		this.thread.start();		
	}
	
	// Puts a new Runnable object in the blocking queue -> to queue will execute 
	// the Runnable when it's turn. 
	public void execute(Runnable r) {
		try {
			if(this.isRunning == true) {
				this.blockingQueue.put(r);
			} 
		} catch (InterruptedException e) { e.printStackTrace();	}
	}
	
	// Puts new Runnable to stop the execution of the blocking-queue.
	// The Runnable is to end of the blocking-queue -> after it, no more Runnables.
	public void shutdown() {
		execute(() -> this.isRunning = false);
	}
}
