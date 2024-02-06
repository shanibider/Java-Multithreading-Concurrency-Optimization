package test;

public interface Future<T> {

	public T get();
	public void set(T t);
}
