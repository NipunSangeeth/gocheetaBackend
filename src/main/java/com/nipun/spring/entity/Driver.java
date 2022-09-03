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

public class Driver {
    @Id
    private String driver_id;
    private String first_name;
    private String last_name ;
    private String contact_number;
    private String branch_id;
    private String vehicle_id;
    private String nic;

}
