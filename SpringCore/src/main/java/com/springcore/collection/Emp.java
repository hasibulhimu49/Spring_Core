
package com.springcore.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class Emp {
    private String name;
    private List<String> phone;
    private Set<String> adddress;
    private Map<String, String> course;
    private Properties props;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    public Set<String> getAdddress() {
        return adddress;
    }

    public void setAdddress(Set<String> adddress) {
        this.adddress = adddress;
    }

    public Map<String, String> getCourse() {
        return course;
    }

    public void setCourse(Map<String, String> course) {
        this.course = course;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public Emp(Properties props) {
        this.props = props;
    }
    

    public Emp(String name, List<String> phone, Set<String> adddress, Map<String, String> course) {
        this.name = name;
        this.phone = phone;
        this.adddress = adddress;
        this.course = course;
    }

    public Emp() {
    }
    
    
    
    
    
    
    
    
}
