package test;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class MyThreadPool {

	int size;
	int next = 0;
	volatile boolean stop = true;
	ActiveObject ao[];
	
	public MyThreadPool(int size) {
		this.ao = new ActiveObject[size];
		this.size = size;
	}
	
	public <T> MyFuture<T> execute(Callable<T> c) { 
		MyFuture<T> res = new MyFuture<>();
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					T v = c.call();
					res.set(v);
				} catch (Exception e) {}
			}
		};
		
		this.submit(r);
		return res;
	}
	
	public void submit(Runnable r) {

		for(int i=0;i<next;i++) {
			if(this.ao[i].size() == 0) {
				this.ao[i].submit(r);
				return;
			}
		}
		
		if(this.ao[next] == null) {
			this.ao[next] = new ActiveObject();
			if(!this.stop) {
				this.ao[next].start();
			}
		}
		
		this.ao[next].submit(r);
		next = (next + 1) % size;
	}
	
	/*
	 * threadpool.submit(r0);
	 * threadpool.start();
	 * threadpool.submit(r1);
	 */
	
	public void start() {
		this.stop = false;
		for(int i=0;i<next;i++) {
			this.ao[i].start();
		}
	}
	
	public void stop() {
		for(int i=0;i<next;i++) {
			this.ao[i].stop();
		}
	}
	
}
