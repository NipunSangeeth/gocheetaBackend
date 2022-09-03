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
public class Customer {
    @Id
//    private String id;
    private String customer_id;
    private String nic;
    private String first_name;
    private String last_name;
    private String email;
    private String contact_number;
    private String addressLine_01 ;
    private String password;
}
