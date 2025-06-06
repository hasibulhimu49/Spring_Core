
package com.springcore.autowiring.annotation;

import com.springcore.autowiring.*;


class Address {
    private String road;
    private String city;

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address(String road, String city) {
        this.road = road;
        this.city = city;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" + "road=" + road + ", city=" + city + '}';
    }
    
    
}
