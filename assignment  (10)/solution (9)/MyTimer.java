package test;

public class MyTimer {

	volatile boolean stop;
	Thread t;
	public MyTimer() {
		t=null;
	}

	public void start(Runnable r, int timesPerSecond) throws Exception{
		if(t==null) {
			t=new Thread(()->{
				while(!stop) {
					r.run();
					try {
						Thread.sleep(1000/timesPerSecond);
					} catch (InterruptedException e) {}
				}
			});
			t.start();
		}else {
			throw new Exception("this timer already runs a task");
		}
	}
	
	public void stop() {
		stop=true;
		t.interrupt();
		t=null;
	}	
}
