package test_1;


public class Train_1 extends Thread{

    // reference to Line's Object. 
    Line_1 line; 
  
    // CTOR.
    Train_1(Line_1 line) 
    { 
        this.line = line; 
    } 
  
    @Override
    public void run() 
    { 
        line.getLine(); 
    }
}