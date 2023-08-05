package org.example.concurrency.blockingqueue;

import java.util.Random;

public class Main {

    private static class Consumer implements Runnable
    {
        private final BlockingQueue myQueue;
        private final Random random = new Random();
        private final int iterations;
        public Consumer(BlockingQueue myQueue,int iterations)
        {
            this.myQueue = myQueue;
            this.iterations = iterations;
        }

        @Override
        public void run()
        {
            try {
                for (int i=0; i< iterations ;i++)
                {
                    Integer item = myQueue.get();
                    System.out.println("Consumed [" + item + "]");
                    Thread.sleep(random.nextInt(0,1000));
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    private static class Producer implements Runnable
    {
        private final BlockingQueue myQueue;
        private final Random random = new Random();
        private final int iterations;
        public Producer(BlockingQueue myQueue, int iterations)
        {
            this.myQueue = myQueue;
            this.iterations = iterations;
        }

        @Override
        public void run()
        {
            try {
                for (int i=0; i< iterations ;i++)
                {
                    Integer item=random.nextInt(1,1000);
                    myQueue.put(item);
                    System.out.println("Put the item [" + item + "] sized ["+myQueue.size()+"]");
                    Thread.sleep(item);
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new BlockingQueue(5);
        Thread consumerthread = new Thread(new Consumer(blockingQueue,100));
        Thread producerthread = new Thread(new Producer(blockingQueue,100));

        consumerthread.start();
        producerthread.start();

        consumerthread.join();
        producerthread.join();
    }
}
