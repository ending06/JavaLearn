package artConcurrent.book.thread.threadpool.impl;

import artConcurrent.book.thread.threadpool.ThreadPool;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/3/7<p>
// -------------------------------------------------------
public class DefaultThreadPoolImpl<Job extends Runnable> implements ThreadPool<Job> {

    /**
     * 线程池默认大小
     * */
    private static final int DEFAULT_WORKER_COUNT = 5;

    /**
     * 线程池最大数量
     * */
    private static final int MAX_WORKER_COUNT = 10;

    /**
     * 线程池最小数量
     * */
    private static final int MIN_WORKER_COUNT = 1;

    /**
     * Job列表
     * */
    private final LinkedList<Job> jobLinkedList = Lists.newLinkedList();

    /**
     * 工作者列表
     * */
    private final List<Worker> workerList = Collections.synchronizedList(new ArrayList<Worker>());

    private int workNum = DEFAULT_WORKER_COUNT;

    /**
     * 线程编号
     * */
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPoolImpl(int count) {
        workNum = (count > MAX_WORKER_COUNT) ? MAX_WORKER_COUNT : count < MIN_WORKER_COUNT ? MIN_WORKER_COUNT : count;
        initWokers(workNum);
    }

    private void initWokers(int count) {
        for (int i = 0; i < count; i++) {
            Worker worker = new Worker();
            workerList.add(worker);

            Thread thread = new Thread(worker, "thread-work" + threadNum.incrementAndGet());

            thread.start();
        }
    }

    @Override
    public void execute(Job job) {
        if (job != null) {
            synchronized (job) {
                jobLinkedList.add(job);
                job.notify();
            }
        }

    }

    @Override
    public void shutdown() {
        for (Worker worker : workerList) {
            worker.shutDown();
        }
    }

    @Override
    public void addWorker(int num) {
        if (num > MAX_WORKER_COUNT) {
            num = MAX_WORKER_COUNT - num;
        }
        initWokers(num);

        this.workNum += num;
    }

    @Override
    public void removeWoker(int num) throws Exception {

        synchronized (jobLinkedList) { // TODO 任务列表加锁，是否会有没有执行完成的任务？？？？？
            if (num > workNum) {
                throw new Exception("移除的数量大于当前工作的线程数量");
            }
            int count = 0;
            while (count < num) {
                Worker worker = workerList.get(count);
                worker.shutDown();
                count++;
            }
            this.workNum -= num;
        }

    }

    @Override
    public int getWaitJobSize() {
        return jobLinkedList.size();
    }

    // --------------------- Change Logs----------------------
    // <p>@author ruirui.qu Initial Created at 18/3/7<p>
    // -------------------------------------------------------
    public class Worker implements Runnable {
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobLinkedList) {
                    while (jobLinkedList.isEmpty()) {
                        try {
                            jobLinkedList.wait();
                        } catch (InterruptedException e) {
                            // 感知到外部对works的中断
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobLinkedList.removeFirst();

                }
                if (job != null) {
                    try {
                        job.run();
                    } catch (Exception e) {
                        System.out.println("执行当前job异常:" + e);
                    }
                }
            }

        }

        public void shutDown() {
            running = false;
        }
    }
}
