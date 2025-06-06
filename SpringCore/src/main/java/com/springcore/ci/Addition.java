
package com.springcore.ci;


public class Addition {
    
    private int a;
    private int b;
    
      public Addition(double a, double b)
    {
        this.a=(int) a;
        this.b=(int) b;
        System.out.println("Constructor: double,double");
    }
    
    public Addition(int a, int b)
    {
        this.a=a;
        this.b=b;
        System.out.println("A="+this.a);
        System.out.println("B="+this.b);
        System.out.println("Constructor: int,int");
        
        
    }
    
   

    @Override
    public String toString() {
        return "Addition{" + "a=" + a + ", b=" + b + '}';
    }
     
     
    
}
