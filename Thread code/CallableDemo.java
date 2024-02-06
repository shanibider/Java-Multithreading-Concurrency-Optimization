package test;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableDemo implements Callable{

	@Override
	public Object call() throws Exception {
		// Creates random number generator.
		Random  generator = new Random();
		
		Integer randomNumber = generator.nextInt(5);
		
		// To simulate a heavy computation,
		// We delay the thread for some random time
		Thread.sleep(randomNumber * 1000);
		
		return randomNumber;
	}

}
