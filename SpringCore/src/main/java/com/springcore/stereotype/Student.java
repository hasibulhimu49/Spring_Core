
package com.springcore.stereotype;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Stu")
@Scope("prototype")
public class Student {
    
    @Value("Hasibul")
    private String studentName;
    @Value("Faridpur")
    private String studentCity;
    
    @Value("#{add}")
    private List<String> studentAddress;

    public List<String> getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(List<String> studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }   
    
}
