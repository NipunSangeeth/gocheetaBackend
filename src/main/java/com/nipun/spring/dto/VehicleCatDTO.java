package com.nipun.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VehicleCatDTO {
    private String Cat_id;
    private String Cat_name;
    private String Cat_type;
}
