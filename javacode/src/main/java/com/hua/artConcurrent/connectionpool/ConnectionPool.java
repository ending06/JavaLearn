package com.hua.artConcurrent.connectionpool;

import java.sql.Connection;
import java.util.LinkedList;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/2<p>
// -------------------------------------------------------
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<Connection>();

    public ConnectionPool(int initSize) {
        if (initSize > 0) {
            for (int i = 0; i < initSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                // 连接释放后，进行通知，这样其他消费者能感受到连接池中已经归还一个连接
                pool.addLast(connection);

                pool.notifyAll();
            }
        }
    }

    // mills内无法获取连接
    public Connection fetConnection(long mills) throws InterruptedException {
        synchronized (pool) {

            if (mills <= 0) {
                while (pool.isEmpty()) {
                    System.out.printf("poll is empty!wait!!");
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;

                long remaining = mills;

                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;

                if (!pool.isEmpty()) {
                    return pool.removeFirst();
                }
                return result;
            }

        }
    }
}
