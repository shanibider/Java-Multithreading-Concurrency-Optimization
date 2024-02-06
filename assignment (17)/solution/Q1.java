package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Q1 {
    private static class MyFuture<V> implements Future<V>{

        V v;
        volatile boolean cancelled, done;

        public synchronized void set(V v){
            this.v=v;
            done=true;
            notifyAll();            
        }

        @Override
        public synchronized boolean cancel(boolean mayInterruptIfRunning) {
            if(isDone())
                return false;
            notifyAll();
            return (cancelled=true);
        }

        @Override
        public boolean isCancelled() {
            return cancelled;
        }

        @Override
        public boolean isDone() {
            return done;
        }

        @Override
        public V get() throws InterruptedException, ExecutionException {
            if (v==null){
                synchronized(this){
                    wait();
                }
            }
            return v;            
        }

        @Override
        public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return null;
        }

    }
    
    
    Runnable r;
    public void execute(){
        if(r!=null)
            r.run();
    }

    public <V> Future<V> submit(Callable<V> c){
        MyFuture<V> f=new MyFuture<>();
        r=()->{
            try{
                f.set(c.call());
            }catch(Exception e){}
        };
        return f;
    }
}
