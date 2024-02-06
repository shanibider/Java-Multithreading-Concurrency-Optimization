package test;

import java.util.concurrent.*;

class MyActiveObject {
    ArrayBlockingQueue<Runnable> q;
    Thread t, t2;
    volatile boolean stop;
    ExecutorService es;
    Thread[] threads = new Thread[2];


    public MyActiveObject() {

        q = new ArrayBlockingQueue<>(10);

        Thread t = new Thread(() -> {
            while (!stop) {
                try {
                    q.take().run();

                } catch (InterruptedException e) {
                }
            }
        });
        t.start();
        threads[0] = t;


        Thread t2 = new Thread(() -> {
            while (!stop) {
                try {
//                    if (q.poll(1000, TimeUnit.SECONDS) == null)
                    Thread.sleep(1000);
                    if (q.poll() == null)
                        stop = true;
                } catch (InterruptedException e) {
                }
            }
        });
        t2.start();
        threads[1] = t;


        es = Executors.newFixedThreadPool(2);

    }


    public void execute(Runnable task) {
        stop = false;
        task.run();
    }


    public void close() {
        stop = true;
        for (int i = 0; i < threads.length; i++) {
            threads[i].interrupt();
        }
    }
}