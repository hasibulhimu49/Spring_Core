package com.springcore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("lifecycleconfig.xml");
        Samosa s = (Samosa) context.getBean("c1");
        System.out.println(s);
        context.registerShutdownHook();

        System.out.println("++++++++++++++++++++++++++");
        Pepsi p = (Pepsi) context.getBean("p1");
        System.out.println(p);

        System.out.println("++++++++++++++++++++++++++");
        Academic a = (Academic) context.getBean("A1");
        System.out.println(a);

    }
}
