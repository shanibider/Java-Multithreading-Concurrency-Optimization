package test;

public class main {

	public static void main(String[] args) {
		
		System.out.println("Main thread is - " + Thread.currentThread().getName());
		
		Thread t1 = new Thread(new RunnableDemo());
		t1.start(); // output -> Thread-0, executing run() method!
		
		Thread t2 = new Thread(new RunnableDemo());
		t2.start(); // output -> Thread-1, executing run() method!
		
		Thread t3 = new Thread(new RunnableDemo(), "myThread3");
		t3.start(); // // output -> myThread3, executing run() method!
	}

}
