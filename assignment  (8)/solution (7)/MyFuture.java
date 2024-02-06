package test;

import java.util.function.Consumer;
import java.util.function.Function;

public class MyFuture<V> {
	private V v;
	Runnable r;
	
	public void set(V v) {
		this.v=v;
		r.run();
	}
	
	public <R> MyFuture<R> thenDo(Function<V, R> f){
		MyFuture<R> mf=new MyFuture<>();
		r=()->mf.set(f.apply(v));
		return mf;
	}
	
	public void finallyDo(Consumer<V> c) {
		r=()->c.accept(v);
	}
}
