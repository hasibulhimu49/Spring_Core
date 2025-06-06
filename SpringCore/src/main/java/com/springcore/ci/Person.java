
package com.springcore.ci;

import java.util.List;


public class Person {
    private String personName;
    private int personId;
    private Certi Certificate;
    private List<String> address;

    public Person(String personName, int personId,Certi Certificate,List<String>address) {
        this.personName = personName;
        this.personId = personId;
        this.Certificate=Certificate;
        this.address=address;
    }

    @Override
    public String toString()
    {
        return personName+" : "+personId+"{"+this.Certificate.name+"}"+address ;
    }

  
    
    
    
    
    
}
