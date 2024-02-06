package test_2;

public class Line_2 {

    // if multiple threads(trains) trying to access 
    // this synchronized method on the same Object 
    // but only one thread will be able 
    // to execute it at a time. 
	
    synchronized public void getLine() 
    { 
        for (int i = 0; i < 3; i++) 
        { 
            System.out.println(i); 
            try { Thread.sleep(400); } 
            catch (Exception e) { System.out.println(e); } 
        } 
    }
}
