package test_2;

import test_2.Line_2;

public class Train_2 extends Thread{

    // reference to Line's Object. 
    Line_2 line; 
  
    // CTOR.
    Train_2(Line_2 line) 
    { 
        this.line = line; 
    } 
  
    @Override
    public void run() 
    { 
        line.getLine(); 
    }
}
