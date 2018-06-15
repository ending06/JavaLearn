package com.hua.artConcurrent.threadpoolexexcutor;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/23<p>
// -------------------------------------------------------
public class ConcurrentTaskTest {

    private final ConcurrentMap<Object, Future<String>> taskCache = new ConcurrentHashMap<Object, Future<String>>();

    private String executionTask(final String taskName) {
        while (true) {
            Future<String> future = taskCache.get(taskName);

            if (future == null) {
                Callable<String> task = new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return taskName;
                    }
                };

                // 创建任务
                FutureTask<String> futureTask = new FutureTask<String>(task);

                future = taskCache.putIfAbsent(taskName, futureTask); // 加入任务

                if (future == null) {
                    future = futureTask;
                    futureTask.run(); // 执行任务
                }
            }

            try {
                return future.get(); // 线程在此等待任务被执行

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}
