package com.springcore.javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.springcore.javaconfig"})
public class Student {
    
    public void study()
    {
        System.out.println("Student is studying book");
    }
    
}
