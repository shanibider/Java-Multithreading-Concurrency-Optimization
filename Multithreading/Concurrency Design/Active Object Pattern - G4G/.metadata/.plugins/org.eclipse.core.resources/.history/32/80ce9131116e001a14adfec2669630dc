package test;

public class Main {

	public static void main(String[] args) {
	
		ActiveObject activeObject = new ActiveObject();
		
		Thread t1 = new Thread(() -> { activeObject.doTask("1", 100); });
		Thread t2 = new Thread(() -> { activeObject.doTask("2", 200); });
		Thread t3 = new Thread(() -> { activeObject.doTask("3", 300); });
		Thread t4 = new Thread(() -> { activeObject.doTask("4", 40); });
		Thread t5 = new Thread(() -> { activeObject.doTask("5", 50); });
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		// Output:  Executing task 1
		// 		    Executing task 4
		// 		    Executing task 5
		// 			Executing task 2
		// 			Executing task 3
	}
}

