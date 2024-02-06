package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class PooledThread{

	BlockingQueue<Runnable> queue;
	
	public PooledThread() {
	
		queue=new ArrayBlockingQueue<Runnable>(100); 		
		new Thread(()->{
			Runnable task;
			try {
				while((task=queue.poll(1, TimeUnit.SECONDS))!=null)
					task.run();				
			} catch (InterruptedException e) {}
		}).start();
	}
	
	
	public void add(Runnable task) {
		try {
			queue.put(task);
		} catch (InterruptedException e) {}
	}
	
}
