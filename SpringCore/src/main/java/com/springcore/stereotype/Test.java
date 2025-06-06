package com.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("stereotypeconfig.xml");
        Student s=(Student) context.getBean("Stu",Student.class);
          System.out.println(s.hashCode());
//        System.out.println(s.getStudentName());
//        System.out.println(s.getStudentCity());
//        System.out.println(s.getStudentAddress());
        
          
           Student s2=(Student) context.getBean("Stu",Student.class);
           System.out.println(s2.hashCode());
        
    }
    
}
