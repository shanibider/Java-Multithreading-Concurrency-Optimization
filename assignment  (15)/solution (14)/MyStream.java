package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<E> implements Stoppable{

	ArrayBlockingQueue<E> queue;
	Consumer<E> c;
	Thread t;
	volatile boolean stop;
	Stoppable next;
	
	public MyStream() {
		queue=new ArrayBlockingQueue<>(100);		
		t=new Thread(()->{			
			while(!stop) {
				try {
					if(c!=null)
						c.accept(queue.take());
				} catch (InterruptedException e) {}
			}
		});
		t.start();
	}
	
	public void add(E e) {
		try {
			queue.put(e);
		} catch (InterruptedException e1) {}
	}
	
	public MyStream<E> filter(Predicate<E> p){
		MyStream<E> next=new MyStream<>();		
		c=e->{if(p.test(e)) next.add(e);};
		this.next=next;
		return next;
	}
	
	public <R> MyStream<R> map(Function<E, R> f){
		MyStream<R> next=new MyStream<>();
		c=e->next.add(f.apply(e));
		this.next=next;
		return next;
	}
	
	public void forEach(Consumer<E> c) {
		this.c=c;
	}
	

	@Override
	public void stop() {
		stop=true;
		t.interrupt();
		if(next!=null)
			next.stop();
	}	
}
