package com.hua.java.acculate.classloader;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/6/19<p>
// -------------------------------------------------------
public class ClassLoaderInit {

    private String name;

    public static final int price = 10;

    static {
        System.out.println("Initializing"); // 静态子句，只在类第一次被加载并初始化时执行一次，而且只执行一次
    }

    ClassLoaderInit() {
        System.out.println("Building"); // 构造方法，在每次声明新对象时加载
    }

    ClassLoaderInit(String name) {
        this.name = name;
    }

    public String playToy(String player) {
        String msg = buildMsg(player);
        System.out.println(msg);
        return msg;
    }

    private String buildMsg(String player) {
        String msg = player + " plays " + name;
        return msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getPrice() {
        return price;
    }

    public static void main(String[] args) {
        System.out.println("编译时常量===>"+ClassLoaderInit.price);
    }
}
