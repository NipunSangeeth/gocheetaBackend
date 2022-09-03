package com.nipun.spring.service;

import com.nipun.spring.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void addVehicle(VehicleDTO dto);
    VehicleDTO searchVehicleDetail (String driver_id);
    void updateVehicledetail(VehicleDTO dto);
    void deleteVehicle(String vehicle_id);
    List<VehicleDTO> getallVehicleList();

}
