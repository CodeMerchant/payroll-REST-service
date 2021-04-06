package com.example.Payroll;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER_ORDER")
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Status status;

    Order(String description, Status status){
        this.description = description;
        this.status = status;
    }
}
