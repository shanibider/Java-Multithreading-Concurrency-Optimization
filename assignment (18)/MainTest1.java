package test;

import java.util.Random;

public class MainTest1 {
    public static class ABC{
        int x;
        public void bla(){ x=0;}
        public void incc(){x++;}
        public void blaincl(int len){x+=len;}
        public void setbla(int[] a,int ind){
            a[ind]=x;
        }
    }

    public static class CBA{
        float x;
        public void start1(){ x=0;}
        public void dec2(){x--;}
        public void decl3(float len){x-=len;}
        public void place4(float[] a,int ind){
            a[ind]=x;
        }
    }

    public static void testA(){
        Random r=new Random();
        int initCount=Thread.activeCount();
        GenericActiveObject gao=new GenericActiveObject(new ABC());
        if(Thread.activeCount()!=initCount)        
            System.out.println("your active object should not open a new thread yet (-5)");
        
        gao.execute("bla");
        if(Thread.activeCount()!=initCount+1)
            System.out.println("your active object did not open a new thread when it should have (-5)");
        gao.execute("incc");        
        int l=r.nextInt(100);
        gao.execute("blaincl",l);
        int ind=r.nextInt(10);
        int ar[]=new int[10];
        gao.execute("setbla", ar,ind);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}

        if(ar[ind]!=l+1)
            System.out.println("your active object did not perform the actions (-10)");

        
        gao.shutdown();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}
        if(Thread.activeCount()!=initCount)        
            System.out.println("your active object did not close its thread (-5)");
    }

    public static void testB(){
        Random r=new Random();
        int initCount=Thread.activeCount();
        GenericActiveObject gao=new GenericActiveObject(new CBA());
        if(Thread.activeCount()!=initCount)        
            System.out.println("your active object should not open a new thread yet (-5)");
        
        gao.execute("start1");
        if(Thread.activeCount()!=initCount+1)
            System.out.println("your active object did not open a new thread when it should have (-5)");
        gao.execute("dec2");        
        int l=r.nextInt(100);
        gao.execute("decl3",l);
        int ind=r.nextInt(10);
        float ar[]=new float[10];
        gao.execute("place4", ar,ind);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}

        if(ar[ind]!=-l-1)
            System.out.println("your active object did not perform the actions (-10)");

        
        gao.shutdown();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}
        if(Thread.activeCount()!=initCount)        
            System.out.println("your active object did not close its thread (-5)");
    }


    public static void main(String[] args) {
        try{
            if(Math.random()>0.5)
                testA();
            else
               testB();
        }catch(Exception e){
            System.out.println("your code threw an exception (-25)");
        }
        System.out.println("done");
    }
}
