package test;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;

public class MyCompletableFuture<T> implements Future<T> {

	Thread t;
	Consumer<T> cons;
	Future<T> f = new MyFuture<>();
	
	public MyCompletableFuture(Callable<T> c) {
		this.t = new Thread(() -> {
			T t;
			try {
				t = c.call();
				if(cons != null) {
					cons.accept(t);
				}
				this.set(t);
			} catch (Exception e) {}
		});
		
		t.start();
	}
	
	public <V> MyCompletableFuture<V> andThen(Function<T, V> f) {
		this.cons = null;
		return new MyCompletableFuture<>(() -> f.apply(this.get()));
	}
	
	public void thenAccept(Consumer<T> c) {
		this.cons = c;
	}
	
	@Override
	public T get() {
		return f.get();
	}

	@Override
	public void set(T t) {
		f.set(t);
	}

	
	
}
