package test;


public class ControllerMaker {

	private static class Helper{
		public static Controller c=new Controller();
	}
	
	public static Controller get() {
		return Helper.c;
	}

}
