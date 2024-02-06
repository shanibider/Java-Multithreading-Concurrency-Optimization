package test;

import java.util.concurrent.atomic.AtomicInteger;

public class Count {
	//int count;
	AtomicInteger i;
	public Count() {
		//count=0;
		i=new AtomicInteger(); 
	}
	
	public  void inc() {
		//count++;
		i.incrementAndGet();
	}
	
	public int get() {
		return i.get();
		//return count;
	}
}
