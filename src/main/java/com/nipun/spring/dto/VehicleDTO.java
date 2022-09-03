package com.nipun.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VehicleDTO {
    private String vehicle_id;
    private String vehicle_name;
    private String vehicle_number ;
    private String vehicle_cat;
    private String driver_id;
    private String branch_id;
}
