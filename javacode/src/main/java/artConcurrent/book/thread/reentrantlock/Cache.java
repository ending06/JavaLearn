package artConcurrent.book.thread.reentrantlock;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/3/8<p>
// -------------------------------------------------------
public class Cache {
    private static final Map<String, String> map = Maps.newHashMap();

    private static final ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    private static final ReentrantReadWriteLock.ReadLock reader = rwlock.readLock();

    private static final ReentrantReadWriteLock.WriteLock write = rwlock.writeLock();

    public static final Object get(String key) {
        reader.lock();
        try {
            return map.get(key);
        } finally {
            reader.unlock();
        }
    }

    public static final String put(String key, String value) {
        write.lock();
        try {
            return map.put(key, value);
        } finally {
            write.unlock();
        }
    }

    public static final void clear() {
        write.lock();
        try {
            map.clear();
        } finally {
            write.unlock();
        }
    }
}
