package artConcurrent.book.thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/3/15<p>
// -------------------------------------------------------
public class ForkJoinTest extends RecursiveTask<Integer> {
    private static final int THREADHOLD = 2;

    private int start;

    private int end;

    public ForkJoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (start-end)<=THREADHOLD;
        if(canCompute){
            for(int i = start;i<=end;i++){
                sum+=i;
            }
        }else {
            int middle = (start+end)/2;

            ForkJoinTest leftCount = new ForkJoinTest(start,middle);
            ForkJoinTest rightCount = new ForkJoinTest(middle+1,end);

            leftCount.fork();
            rightCount.fork();

            int leftResult = leftCount.join();

            int rightResult = rightCount.join();

            sum = leftResult+rightResult;
        }
        return sum;
    }
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        //生成一个任务计算任务
        ForkJoinTest countTask = new ForkJoinTest(1,100);

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
