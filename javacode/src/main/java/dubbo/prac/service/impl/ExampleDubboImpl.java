package dubbo.prac.service.impl;

import dubbo.prac.service.ExampleDubbo;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/5/8<p>
// -------------------------------------------------------
public class ExampleDubboImpl implements ExampleDubbo {
    @Override
    public void sayHello() {
        System.out.printf("hello");
    }
}
