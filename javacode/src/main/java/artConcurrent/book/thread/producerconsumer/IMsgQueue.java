package artConcurrent.book.thread.producerconsumer;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/23<p>
// -------------------------------------------------------
public interface IMsgQueue {

    void put(Message msg);

    Message take();
}
