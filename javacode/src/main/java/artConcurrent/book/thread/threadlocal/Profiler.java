package artConcurrent.book.thread.threadlocal;

import java.util.concurrent.TimeUnit;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/2<p>
// -------------------------------------------------------
public class Profiler {
    // 第一次get方法调用时，会进行初始化
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        System.out.printf("begin:" + System.currentTimeMillis()+"\n");
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final Long end() {
        System.out.printf("end:" + System.currentTimeMillis()+"\n");
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        Profiler.begin();

        TimeUnit.SECONDS.sleep(1);

        System.out.printf("Cost:" + Profiler.end() + "mills");
    }
}
