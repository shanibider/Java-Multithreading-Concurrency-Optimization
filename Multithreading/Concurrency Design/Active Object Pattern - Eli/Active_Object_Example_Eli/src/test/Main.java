package test;

// Every thread will get the name 'Thread-0' because for each run, 
// there only one thread running

public class Main {

	public static void main(String[] args) {
		// Creates the Active Object. 
		MyGenericActiveObject mgao = new MyGenericActiveObject();
	
		// 1. Puts a Runnable in the blockingQueue.
		mgao.execute(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 5; i++) {
					System.out.println(Thread.currentThread().getName() + 
									   ": counting... " + i + " ...");
					
					try { Thread.sleep(2000); } 
					catch (InterruptedException e) {e.printStackTrace(); }
					
				if(i%2 == 0) { System.out.println(Thread.currentThread().getName() + 
						   						  ": " + i + " is even!"); }
				else { System.out.println(Thread.currentThread().getName() + 
										  ": " + i + " is odd!"); }
				
				try { Thread.sleep(2000); } 
				catch (InterruptedException e) {e.printStackTrace(); }
				}				
			}
		});
		
		// 2. Puts a Runnable in the blockingQueue.
		String[] animals = {"Dog", "Cat", "Bird", "Bug", "Hawk", "Tiger"};
		mgao.execute(new Runnable() {
			
			@Override
			public void run() {
				for (String animal : animals) {
					System.out.println(Thread.currentThread().getName() + ": " +
							   animal + " is very cool!");
					
					try { Thread.sleep(1500); } 
					catch (InterruptedException e) {e.printStackTrace(); }
					
					System.out.println(Thread.currentThread().getName() + ": " +
							animal + " has " + animal.length() + " letters in it's name");
				}			
			}
		});
		
		// Stooping the blocking-queue from execution more Runnables. 
		mgao.shutdown();
		
		// 3. Won't run.
		mgao.execute(new Runnable() {
			
			@Override
			public void run() {
				for (String animal : animals) {
					System.out.println(Thread.currentThread().getName() + ": " +
									   animal + " is very cool!");
					
					try { Thread.sleep(2000); } 
					catch (InterruptedException e) {e.printStackTrace(); }
					
					System.out.println(Thread.currentThread().getName() + ": " +
					animal + " has " + animal.length() + " letters in it's name");
				}			
			}
		});
		
		System.out.println("\n--- Main is dead. ---\n");
	}
}
