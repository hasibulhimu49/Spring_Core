package com.springcore.autowiring.annotation;

import com.springcore.autowiring.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Employee {
    @Autowired
    @Qualifier("address2")
    private Address address;

    public Address getAddress() {
        return address;
    }
    //@Autowired
    public void setAddress(Address address) {
        System.out.println("Inside Setter");
        this.address = address;
    }
    //@Autowired
    public Employee(Address address) {
         System.out.println("Inside Constructor");
        this.address = address;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee:" +address ;
    }
    
  
}
