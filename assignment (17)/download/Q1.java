package test;


public class Q1 {
    private static class MyFuture<V> implements Future<V>{


        public void set(V v){
        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }

        @Override
        public boolean isCancelled() {
            return false;
        }

        @Override
        public boolean isDone() {
            return false;
        }

        @Override
        public V get() throws InterruptedException, ExecutionException {
            return null;  
        }

        @Override
        public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
			// no need to implement
            return null;
        }

    }
    
    
    public void execute(){
    }

    public <V> Future<V> submit(Callable<V> c){
        return null;
    }
}
