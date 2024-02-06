package test;

// 4. Thread Safe Singleton: A thread safe singleton in created so that singleton property
// is maintained even in multithreaded environment. 
// To make a singleton class thread-safe, getInstance() method is made 
// synchronized so that multiple threads can’t access it simultaneously.

// Thread Safe Singleton
public class Singleton_4 {
	// Private instance, so that it can be 
	// accessed by only by getInstance() method
	private static Singleton_4 instance;
	
	// Private CTOR.
	private Singleton_4() {	}
	
	// Synchronized method to control simultaneous access 
	synchronized public static Singleton_4 getInstance() {
		if(instance == null) {
			// if instance is null, initialize
			instance = new Singleton_4();
		}
		
		return instance;
	}
}

// Pros:
// 1. Lazy initialization is possible.
// 2. is also thread safe.

// Cons:
// 1. getInstance() method is synchronized so it causes slow performance 
// as multiple threads can’t access it simultaneously.