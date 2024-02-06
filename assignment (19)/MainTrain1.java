package test;

import java.util.Random;

public class MainTrain1 {


    public static void main(String[] args) {
        int c=Thread.activeCount();
        MyActiveObject a=new MyActiveObject();
        if(Thread.activeCount()!=c+2){
            System.out.println("your code did not open 2 threads (-25)");
            System.out.println("done");
            a.close();
            return;
        }
        Random r=new Random();
        final int x = r.nextInt(1000);
        int arr[]={0};
        a.execute(()->arr[0]=x);
        try {Thread.sleep(100);} catch (InterruptedException e) {}
        if(arr[0]!=x)
            System.out.println("your active object did not execute the task (-5)");
        
        // wait for the execution thread to close
        try {Thread.sleep(1100);} catch (InterruptedException e) {}
        if(Thread.activeCount()!=c+1)
            System.out.println("you did not close the execution thread after a second (-10)");  

        final int y = r.nextInt(1000);
        arr[0]=-1;
        a.execute(()->arr[0]=y);  // should reopen the execution thread
        int c3=Thread.activeCount();
        try {Thread.sleep(100);} catch (InterruptedException e) {}
        if(arr[0]!=y || c3!=c+2){
            System.out.println("your active object did not execute the task in a new thread (-5)");
        }
        a.close();
        try {Thread.sleep(1100);} catch (InterruptedException e) {}
        if(Thread.activeCount()!=c){
            System.out.println("you did not close all the threads (-5)");
        }
        System.out.println("done");
    }
}
