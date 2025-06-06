
package com.springcore.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("collectionconfig.xml");
        Emp emp1=(Emp)context.getBean("emp1");
        
        System.out.println(emp1.getName());
        System.out.println(emp1.getPhone());
        System.out.println(emp1.getAdddress());
        System.out.println(emp1.getCourse());
        System.out.println(emp1.getProps());
        System.out.println(emp1.getPhone().getClass().getName());
        
    }
    
}
