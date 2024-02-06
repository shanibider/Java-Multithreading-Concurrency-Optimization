package test_1;

public class MainWithoutSynchronized {

	// Example illustrates multiple threads are executing 
	// on the same Object at same time without synchronization. 
	
	 public static void main(String[] args) {
	        // Object of Line class that is shared 
	        // among the threads. 
	        Line_1 obj = new Line_1(); 
	  
	        // creating the threads that are 
	        // sharing the same Object. 
	        Train_1 train1 = new Train_1(obj); 
	        Train_1 train2 = new Train_1(obj); 
	  
	        // threads start their execution. 
	        train1.start(); 
	        train2.start();
	        
	        // output:
	        // 0
	        // 0
	        // 1
	        // 1
	        // 2
	        // 2
	        
	        // Wrong!!! -> There can be two trains (more than two) 
	        // which need to use same at same time so there is chance of collision. 
	        // Therefore to avoid collision we need to synchronize the line in which multiple want to run.
	        
	 }
}
