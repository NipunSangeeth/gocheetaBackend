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

public class Booking {
    @Id
    private String reservation_number;
    private String duration;
    private String amount ;
    private String customer_id;
    private String branch_id;
    private String vehicle_id;
}
