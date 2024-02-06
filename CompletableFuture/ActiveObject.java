package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ActiveObject {

	protected BlockingQueue<Runnable> q = new ArrayBlockingQueue<>(100);
	protected volatile boolean stop = false;
	protected Thread activeThread;
	protected long lastTask = 0;
	
	protected void run() {
		while(!this.stop && System.currentTimeMillis() - lastTask > 1000) {
			try {
				this.q.take().run();
			} catch (InterruptedException e) {}
		}
		
	
	}
	
	public void start() {
		this.stop = false;

		this.activeThread = new Thread(() -> this.run());
		
	
		this.activeThread.start();
		lastTask = System.currentTimeMillis();
	}
	
	public void stop() {
		this.stop = true;
		this.q.add(() -> this.stop = true);
		try {
			this.activeThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void submit(Runnable r) {
		try {
			if(System.currentTimeMillis() - lastTask < 1000) {
				lastTask = System.currentTimeMillis();
			}
			q.put(r);
		} catch (InterruptedException e) {}
	}
	
	public int size() {
		return this.q.size();
	}
	
}
