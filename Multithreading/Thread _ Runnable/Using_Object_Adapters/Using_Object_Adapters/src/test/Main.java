package test;

public class main {

	public static void main(String[] args) {
		Thread t1 = new Thread(new TaskRunnable(new MyTask()), "t1");
		Thread t2 = new Thread(new TaskRunnable(new MyTask()), "t2");
		
		t1.start(); // Opens a thread.
		t2.start(); // Opens a thread, not the same!
	}
}