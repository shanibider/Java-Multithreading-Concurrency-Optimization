package test;

public class MyFuture<T> implements Future<T> {

	private T val;
	private volatile boolean isSet  = false;
	synchronized public T get() {
		if(!isSet) {
			try {
				//
				this.wait();
			} catch (InterruptedException e) {}
		}

		return this.val;
	}
	
	synchronized public void set(T val) {
		this.val = val;
		this.isSet = true;
		this.notifyAll();
	}
	
}
