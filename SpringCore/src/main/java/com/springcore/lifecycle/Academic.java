
package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Academic {
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Academic() {
    }

    @Override
    public String toString() {
        return "Academic=" + subject;
    }
    
    @PostConstruct
    public void start()
    {
        System.out.println("Starting");
    }
    @PreDestroy
    public void End()
    {
        System.out.println("Ending");
    }
    
    
}
