package artConcurrent.book.thread.threadpoolexexcutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/23<p>
// -------------------------------------------------------
public class ThreadPoolExecutorTest {

    int corePoolSize;

    int maximumPoolSize;

    long keepAliveTime;

    TimeUnit unit;

    BlockingQueue<Runnable> workQueue = null;
}
