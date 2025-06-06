
package com.springcore.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TeestCI {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ciconfig.xml");
        Person p=(Person)context.getBean("person1");
        System.out.println(p);
        
        Addition a=(Addition)context.getBean("amb");
        System.out.println(a);
        
    }
}
