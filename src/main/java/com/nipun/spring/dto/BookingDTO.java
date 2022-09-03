package com.nipun.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private String reservation_number;
    private String duration;
    private String amount ;
    private String customer_id;
    private String branch_id;
    private String vehicle_id;
}
