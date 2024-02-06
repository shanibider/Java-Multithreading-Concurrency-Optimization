package test;

import java.util.concurrent.Callable;

public class CallableWorker implements Callable<Worker> {
	@Override
	public Worker call() throws Exception {
		Thread.sleep(3000);
		return new Worker();
	}
}
