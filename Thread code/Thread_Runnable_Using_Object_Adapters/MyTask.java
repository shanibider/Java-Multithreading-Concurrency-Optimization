package test;

public class MyTask implements Task{

	@Override
	public void doTask() {
		System.out.println("Let's count to 8");
		
		for (int i = 0; i < 9; i++) {
			System.out.println(Thread.currentThread().getName() + ": ..." + i + "...");
		}
	}

}
