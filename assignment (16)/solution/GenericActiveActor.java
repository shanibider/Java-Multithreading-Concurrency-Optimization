package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.Consumer;

public class GenericActiveActor extends Actor{

	ArrayBlockingQueue<String> q;
	Thread t;
	volatile boolean stop;
	
	public GenericActiveActor(int id, Consumer<String> logic) {
		super(id);
		q=new ArrayBlockingQueue<String>(100);
		stop=false;
		t=new Thread(()->{
			while(!stop) {
				try {
					String msg = q.take();
					
					if(msg.equals("stop"))
						stop=true;
					else 
						logic.accept(msg);
					
				} catch (InterruptedException e) {}
			}
		});
		t.start();
	}

	@Override
	void addMessage(String msg) {
		try {q.put(msg);} catch (InterruptedException e) {}
	}

	@Override
	void close() {
		addMessage("stop");
	}

}
