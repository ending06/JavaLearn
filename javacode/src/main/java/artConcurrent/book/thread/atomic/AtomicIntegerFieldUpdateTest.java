package com.java.spring.atomic;

import com.google.common.base.Objects;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/17<p>
//-------------------------------------------------------
public class AtomicIntegerFieldUpdateTest {
    private static final AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class,"age");

    public static void main(String[] args) {
        User kenan = new User("kenan",10);
        System.out.println(a.getAndIncrement(kenan));

        System.out.println(a.get(kenan));

        System.out.println(kenan.getName()+";"+kenan.getAge());

    }



    public static class User{
        private String name;

        public volatile int age;

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
