package com.hua.artConcurrent.threadpool;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/3/7<p>
//-------------------------------------------------------
public interface ThreadPool<Job extends Runnable> {

    /**
     * 执行一个Job 这个Job需要实现Runnable接口
     * */
    void execute(Job job);

    /**
     * 关闭线程池
     * */
    void shutdown();

    /**
     * 增加工作者线程
     * */
    void addWorker(int num);

    /**
     * 减少工作者线程
     * */
    void removeWoker(int num) throws Exception;

    /**
     * 得到当前等待执行的任务数量
     * */
    int getWaitJobSize();
}
