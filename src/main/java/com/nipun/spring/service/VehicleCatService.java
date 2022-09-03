package com.nipun.spring.service;

import com.nipun.spring.dto.VehicleCatDTO;

import java.util.List;

public interface VehicleCatService {
    void addVehicleCat(VehicleCatDTO dto);
    VehicleCatDTO searchVehicleCatDetail (String vehicle_id);
    void updateVehicleCatdetail(VehicleCatDTO dto);
    void deleteVehicleCat(String vehicle_id);
    List<VehicleCatDTO> getallVehicleCatList();

}
