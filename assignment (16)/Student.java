package test;


public class Student {
	
	private static int count=0;
	
	public  Student() {
		count++;
	}
	
	public static int getCount() {
		return count;
	}
	
	// rest code of student...

}
