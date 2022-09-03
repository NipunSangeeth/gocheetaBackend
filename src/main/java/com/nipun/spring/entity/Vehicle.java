package com.nipun.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Vehicle {
    @Id
    private String vehicle_id;
    private String vehicle_name;
    private String vehicle_number ;
    private String vehicle_cat;
    private String driver_id;
    private String branch_id;
}
