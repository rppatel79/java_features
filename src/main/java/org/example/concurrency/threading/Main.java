package org.example.concurrency.threading;

import java.util.concurrent.*;

public class Main {
    private static class WorkerRunnable implements Runnable
    {
        @Override
        public void run() {
            System.out.println("I'm running a worker!");
        }
    }

    private static class WorkerCallable implements Callable<Boolean>
    {
        @Override
        public Boolean call() throws Exception {
            System.out.println("I'm running a worker!");
            return Boolean.TRUE;
        }
    }


    public void extendThreadApproach() throws Exception
    {
        Thread t = null;
        try {
            t = new Thread() {
                private Runnable run = new WorkerRunnable();

                @Override
                public synchronized void run() {
                    run.run();
                }
            };
            t.start();
        }
        finally {
            try {
                if (t != null) t.join();
            }
            catch(Exception ex)
            {
                ex.printStackTrace(System.out);
            }
        }

    }

    private void passARunable() throws Exception
    {
        Thread t =null;
        try {
            t = new Thread(new WorkerRunnable());
            t.start();
        }
        finally{
            try{
                t.join();
            }
            catch(Exception ex)
            {
                ex.printStackTrace(System.out);
            }
        }

}

    private void executorService() throws Exception
    {
        ExecutorService service = Executors.newFixedThreadPool(1);
        try {
            {
                Future<?> future = service.submit(new WorkerRunnable());
                future.get();
            }
            {
                Future<Boolean> future = service.submit(new WorkerCallable());
                assert future.get() == Boolean.TRUE;
            }
        }
        finally
        {
            service.shutdown();
        }
    }


    public static void main(String[] args) throws Exception
    {
        Main main = new Main();
        main.extendThreadApproach();
        main.passARunable();
        main.executorService();
    }

}
