
package com.springcore.autowiring.annotation;

import com.springcore.autowiring.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotationautowiringconfig.xml");
        Employee e=(Employee)context.getBean("Emp1");
        System.out.println(e);
                
    }
    
}
