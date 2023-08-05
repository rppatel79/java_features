package org.example.concurrency.blockingqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition empty = lock.newCondition();
    private final Condition full = lock.newCondition();

    private final List<Integer> items = new ArrayList<>();
    private final int maxSize;

    public BlockingQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public Integer get() throws InterruptedException {
        lock.lock();
        try
        {
            while(items.size()==0)
                empty.await();


            return items.remove(0);
        }
        finally {
            full.signal();
            lock.unlock();
        }
    }

    public void put(Integer item) throws InterruptedException {
        lock.lock();
        try
        {
            while (items.size() == maxSize)
                full.await();

            items.add(item);
            empty.signal();
        }
        finally {
            lock.unlock();
        }
    }

    public int size()
    {
        return items.size();
    }
}
