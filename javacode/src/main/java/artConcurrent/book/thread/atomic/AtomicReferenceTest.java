package artConcurrent.book.thread.atomic;

import com.google.common.base.Objects;

import java.util.concurrent.atomic.AtomicReference;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/17<p>
//-------------------------------------------------------
public class AtomicReferenceTest {
    private static final AtomicReference<User> userReference = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("tiancheng",11);
        userReference.set(user);

        User updateUser = new User("feifei",12);

        //检查当前值是否=user  如果是则updateUser  否返回原值
        userReference.compareAndSet(user,updateUser);

        System.out.println(userReference.get().getName());
        System.out.println(userReference.get().getAge());

    }

    private static class User{
        private String name;

        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override public String toString() {
            return Objects.toStringHelper(this).add("name", name).add("age", age).toString();
        }
    }
}
