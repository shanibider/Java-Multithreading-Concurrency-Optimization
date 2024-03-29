package test;

// java.lang.Runnable is an interface that is to be implemented by a class whose 
// instances are intended to be executed by a thread.
// There are two ways to start a new Thread � (1) Subclass Thread and (2) implement Runnable.
// There is no need of subclassing Thread when a
// task can be done by overriding only run() method of Runnable.

// Steps to create a new Thread using Runnable :
// 1. Create a Runnable implementer and implement run() method.
// 2. Instantiate Thread class and pass the implementer to the Thread,
// 	  Thread has a constructor which accepts Runnable instance.
// 3. Invoke start() of Thread instance, 
// 	  start internally calls run() of the implementer. 
//	  Invoking start(), creates a new Thread which executes the code written in run().


// --> Calling run() directly doesn�t create and start a new Thread, it will run in the same thread. 
// 	   To start a new line of execution, call start() on the thread. 


// What happens when Runnable encounters an exception ?
// Runnable can�t throw checked exception but RuntimeException can be thrown from run(). 
// Uncaught exceptions are handled by exception handler of the thread, 
// if JVM can�t handle or catch exceptions, it prints the stack trace and terminates the flow.


public class RunnableDemo implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ", executing run() method!");
	}

}
