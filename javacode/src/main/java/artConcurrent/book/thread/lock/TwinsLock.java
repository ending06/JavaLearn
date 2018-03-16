package artConcurrent.book.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/3/7<p>
// -------------------------------------------------------
public class TwinsLock implements Lock {
    private final Sync sync = new Sync(2);

    @Override
    public void lock() {
        sync.tryAcquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.tryReleaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    // --------------------- Change Logs----------------------
    // <p>@author ruirui.qu Initial Created at 18/3/7<p>
    // -------------------------------------------------------
    private static final class Sync extends AbstractQueuedSynchronizer {

        public Sync(int count) throws IllegalArgumentException {
            if (count <= 0) {
                throw new IllegalArgumentException("参数不合法");
            }
            setState(2);
        }

        @Override
        public int tryAcquireShared(int reduceCount) {
            for (;;) {
                int current = getState();
                int newCount = current - reduceCount;
                if (newCount <= 0 || compareAndSetState(current, newCount)) {
                    return newCount;
                }
            }
        }

        @Override
        public boolean tryReleaseShared(int returnCount) {
            for (;;) {
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }
    }
}
