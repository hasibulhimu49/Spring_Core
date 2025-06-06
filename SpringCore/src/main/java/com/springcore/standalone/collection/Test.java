
package com.springcore.standalone.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("standaloneconfig.xml");
        Person p=(Person)context.getBean("p1");
        
        System.out.println(p.getFriends());
        System.out.println(p.getFriends().getClass().getName());
        
        System.out.println("___________________________________________________");
        
        System.out.println(p.getFeestructure());
        System.out.println(p.getFeestructure().getClass().getName());
        
        System.out.println("___________________________________________________");
                
        System.out.println(p.getProperties());
        System.out.println(p.getClass().getClass().getName());
        
    }
}
