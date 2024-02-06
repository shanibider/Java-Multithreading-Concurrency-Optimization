package test;

// THE BEST WAY!!!!!!

// Bill Pugh Singleton Implementation: Prior to Java5, 
// memory model had a lot of issues and above methods caused
// failure in certain scenarios in multithreaded environment.
// So, Bill Pugh suggested a concept of inner static classes to use for singleton.

// When the singleton class is loaded, 
// inner class is not loaded and hence doesn�t create object when loading the class.
// Inner class is created only when getInstance() method is called. 
// So it may seem like eager initialization but it is lazy initialization.
// This is the most widely used approach as it doesn�t use synchronization.

// Bill Pugh Singleton Implementation
public class Singleton_6 {
	// Private CTOR.
	private Singleton_6() {	}
	
	// Inner class to provide instance of class
	private static class BillPughSingleton {
		private static final Singleton_6 instance = new Singleton_6();
	}
	
	public static Singleton_6 getInstance() {
		System.out.println("instance_6 was made.");
		return BillPughSingleton.instance;
	}
}