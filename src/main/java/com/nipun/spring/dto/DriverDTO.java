package com.nipun.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DriverDTO {
    private String driver_id;
    private String first_name;
    private String last_name ;
    private String contact_number;
    private String branch_id;
    private String vehicle_id;
    private String nic;
    private String password;

}
