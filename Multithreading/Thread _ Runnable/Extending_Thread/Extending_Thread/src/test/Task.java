package test;

public class Task extends Thread{
	public void run() {
		System.out.println("New Thread -> run task executed by child Thread");
		
		System.out.println("New Thread -> count to 10!");
		for(int i = 1; i < 11; i++) {
			try { this.sleep(1000); } 
			catch (InterruptedException e) { e.printStackTrace(); }
			System.out.print(i + "...! ");
		}
	}
	
}
