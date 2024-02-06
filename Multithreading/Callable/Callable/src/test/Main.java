package test;

public class Main {

	public static void main(String[] args) throws Exception {
		CallableDemo cd = new CallableDemo();
		System.out.println(cd.call());
		
		Object x = cd.call();
		System.out.println(x.toString());
	}
}
