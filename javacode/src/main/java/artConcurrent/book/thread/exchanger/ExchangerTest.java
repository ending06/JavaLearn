package artConcurrent.book.thread.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/23<p>
// -------------------------------------------------------
public class ExchangerTest {
    private static final Exchanger<String> exchanger = new Exchanger<String>();

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A";// A录入的银行流水数据
                    exchanger.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水A"; // B录入的银行流水数据
                    String A = exchanger.exchange(B);
                    System.out.println("A和B录入的数据是否一样" + A.equals(B) + ";A录入的是:" + A + ";B录入的是:" + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
