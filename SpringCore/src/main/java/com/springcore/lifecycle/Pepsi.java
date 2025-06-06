package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Pepsi implements InitializingBean,DisposableBean{
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Pepsi() {
    }

    @Override
    public String toString() {
        return "Pepsi="+ price;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Taling Pepsi: init");
    
    
}

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroyyy Bean");
    }
}
