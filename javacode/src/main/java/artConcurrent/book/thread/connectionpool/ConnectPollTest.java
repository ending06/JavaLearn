package artConcurrent.book.thread.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/2<p>
// -------------------------------------------------------
public class ConnectPollTest {

    static ConnectionPool connectionPool = new ConnectionPool(10);

    // 保证所有的connection能同时开始
    static CountDownLatch start = new CountDownLatch(1);

    // main线程将会等所有的connectionRuner结束后才能执行
    static CountDownLatch end;

    public static void main(String[] args) throws Exception {
        int threadCount = 40;

        end = new CountDownLatch(threadCount);

        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "connectionRunnerThread");
            thread.start();

        }

        // ===******=======
        start.countDown();
        end.await();
        System.out.println("total invoke:" + (threadCount * count));
        System.out.println("got connection:" + got);
        System.out.println("not got connection:" + notGot);
    }

    // --------------------- Change Logs----------------------
    // <p>@author ruirui.qu Initial Created at 17/9/2<p>
    // -------------------------------------------------------

    private static class ConnectionRunner implements Runnable {

        private int count;

        private AtomicInteger got;

        private AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (count > 0) {
                try {
                    // 从线程池中获取连接
                    Connection connection = connectionPool.fetConnection(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            connectionPool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}
