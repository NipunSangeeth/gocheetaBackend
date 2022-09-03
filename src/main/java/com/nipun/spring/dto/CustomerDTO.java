package com.nipun.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String customer_id;
    private String nic;
    private String first_name;
    private String last_name;
    private String email;
    private String contact_number;
    private String addressLine_01 ;
    private String password;

}
