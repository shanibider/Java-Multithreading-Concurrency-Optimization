package test;

public class Main {
	public static void testCompletableFuture() {
		MyCompletableFuture<String> f = new MyCompletableFuture<String>(()->{ try {Thread.sleep(5000);} catch (InterruptedException e) {} return "(5+5)*2"; });
		
		f.thenAccept((i)->System.out.println(i));
		long sTime = System.currentTimeMillis();
		f = f.andThen((i)->20.0)
				.andThen(i->{ try {Thread.sleep(5000);} catch (InterruptedException e) {} return "Result is: "+i; });
		System.out.println("Then Accept..");

		f.thenAccept((i)->System.out.println(i));
		
		System.out.println("Completable Future test is done: " + (System.currentTimeMillis() - sTime));
	}
	
	public static void main(String[] args) {

		testCompletableFuture();
				
	}
	
}
