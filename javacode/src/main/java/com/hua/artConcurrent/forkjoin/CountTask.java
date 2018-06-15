package com.hua.artConcurrent.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/17<p>
// -------------------------------------------------------
public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 2;// 阈值

    private int start;

    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        // 如果任务足够小就计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <=end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值，则分列为两个子任务进行处理
            int middle = (start + end) / 2;

            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle+1, end);

            // 执行子任务
            leftTask.fork();
            rightTask.fork();

            // 等待子任务执行完毕，并得到结果
            int leftTaskResult = leftTask.join();
            int rightTaskResult = rightTask.join();

            // 合并子任务
            sum = leftTaskResult + rightTaskResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        //生成一个任务计算任务
        CountTask countTask = new CountTask(1,100);

        //执行任务
        Future<Integer> result = forkJoinPool.submit(countTask);

        try{
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
