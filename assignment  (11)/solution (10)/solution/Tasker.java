package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tasker extends HashMap<String, List<Runnable>>{

	private static final long serialVersionUID = 1L;

	volatile boolean started=false;
	ArrayList<Thread> threads=new ArrayList<>();
	
	@Override
	public List<Runnable> put(String name, List<Runnable> runs){
		if(!started)
			return super.put(name, runs);
		else
			return null;
	}
	
	public void start() {
		forEach((name,runs)->{
			Thread t = new Thread(()->runs.forEach(r->r.run()),name);
			threads.add(t);
			t.start();
		});
	}

	public void join(){
		threads.forEach(t->{
			try {
				t.join();
			} catch (InterruptedException e) {}
		});
	}
	
}
