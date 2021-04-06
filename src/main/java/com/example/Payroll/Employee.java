package com.example.Payroll;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data


public class Employee {
   @Id
   @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String role;

    Employee(String firstName, String lastName, String role){
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
    public String getName(){
        return  this.firstName + " " + this.lastName;
    }
    @NonNull
    public void setName(String name){
        String[] parts = name.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }


}
