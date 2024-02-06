package test;

public class TaskRunnable implements Runnable{

	// Date member.
	private Task task;
	
	// CTOR.
	TaskRunnable(Task otherTask) {
		this.task =  otherTask;
	}

	@Override
	public void run() {
		task.doTask();
	}
}
