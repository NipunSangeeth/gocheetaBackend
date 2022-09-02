package com.nipun.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String nic;
    private String f_name;
    private String l_name;
    private String  phone_no;
    private String street ;
    private String city;
    private String code ;

}
