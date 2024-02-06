package test;

import java.util.Observable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ObservableFuture<V> extends Observable{

	V v;
	public ObservableFuture(Future<V> f) {
		new Thread(()->{
			try {
				v=f.get();
			} catch (InterruptedException e) {}
			catch (ExecutionException e) {}
			setChanged();
			notifyObservers();			
		}).start();
	}
	
	public V get() {
		return v;
	}
}
