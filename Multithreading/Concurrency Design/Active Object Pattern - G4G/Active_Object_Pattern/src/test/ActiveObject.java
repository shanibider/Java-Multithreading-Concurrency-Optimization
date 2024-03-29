package test;

import java.util.concurrent.PriorityBlockingQueue;

public class ActiveObject {

	// Task Class.
	class Task implements Comparable<Task> {

		// Data members:
		int priority;
		String name;
		
		// CTOR.
		public Task(int otherPriority, String otherName) {
			this.priority = otherPriority;
			this.name = otherName;
		}
		
		// Smaller numbers -> higher priority.
		@Override
		public int compareTo(Task otherTask) {
			return Integer.compare(this.priority, otherTask.priority);
		}
	}
	
	// Data members:
	private PriorityBlockingQueue<Task> tasksQueue = new PriorityBlockingQueue<Task>();
	
	public ActiveObject() {
		new Thread (() -> {
			while(true) {
				try {
					Task task = tasksQueue.take();
					System.out.println("Executing task " + task.name);
				} catch (InterruptedException e) { break; }
			}
		}).start();
	}
	
	// Puts the task in the blocking queue.
	public void doTask(String name, int priority) {
		System.out.println("Adding task " + name);
		tasksQueue.put(new Task(priority, name));
	}

}
