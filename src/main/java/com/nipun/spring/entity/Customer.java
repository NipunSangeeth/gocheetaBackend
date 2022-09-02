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
    private String nic;
    private String f_name;
    private String l_name;
    private String  phone_no;
    private String street ;
    private String city;
    private String code ;

}
