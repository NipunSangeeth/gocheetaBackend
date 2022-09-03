package com.nipun.spring.service.impl;


import com.nipun.spring.dto.VehicleDTO;
import com.nipun.spring.entity.Vehicle;
import com.nipun.spring.repo.VehicleRepo;
import com.nipun.spring.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional


public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addVehicle(VehicleDTO dto) {
        if (!repo.existsById(dto.getVehicle_id())) {
            Vehicle c = mapper.map(dto, Vehicle.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Vehicle already exist..!");
        }
    }

    public VehicleDTO searchVehicleDetail(String vehicle_id) {
        Optional<Vehicle> vehicleDetail = repo.findById(vehicle_id);
        if (vehicleDetail.isPresent()) {
            return mapper.map(vehicleDetail.get(), VehicleDTO.class);
        } else {
            throw new RuntimeException("No Vehicle for id: " + vehicle_id);
        }
    }

    @Override
    public void updateVehicledetail(VehicleDTO dto) {
        if (repo.existsById(dto.getVehicle_id())) {
            Vehicle c = mapper.map(dto, Vehicle.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Invalid Update..!");
        }
    }

    @Override
    public void deleteVehicle(String vehicle_id) {
        if (repo.existsById(vehicle_id)) {
            repo.deleteById(vehicle_id);
        } else {
            throw new RuntimeException("No Vehicle for delete ID: " + vehicle_id);
        }

    }

    @Override
    public List<VehicleDTO> getallVehicleList() {
        List<Vehicle> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<VehicleDTO>>() {
        }.getType());
    }
}
