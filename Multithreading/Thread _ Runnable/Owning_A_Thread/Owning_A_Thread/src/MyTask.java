
public class MyTask{

	// Data members:
	private int num;
	private Boolean isOn;
	
	// CTOR.
	public MyTask() {
		this.num = 0;
		this.isOn = true;
	}
	
	public void doTask() {
		// in MyTask class we create a thread using lambda expression!
		new Thread(() -> {
			if(this.isOn == true) { System.out.println("Let's go!"); }
			else { System.out.println("No more counting..."); }
			while(this.isOn == true) { num++; }
		}).start();
	}
	
	public void stopTask() {
		this.isOn = false;
	}
	
	public int getNum() {
		return this.num;
	}
}
