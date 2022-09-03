package com.nipun.spring.service.impl;


import com.nipun.spring.dto.VehicleCatDTO;
import com.nipun.spring.entity.VehicleCat;
import com.nipun.spring.repo.VehicleCatRepo;
import com.nipun.spring.service.VehicleCatService;
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


public class VehicleCatServiceImpl implements VehicleCatService {
    @Autowired
    private VehicleCatRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addVehicleCat(VehicleCatDTO dto) {
        if (!repo.existsById(dto.getCat_id())) {
            VehicleCat c = mapper.map(dto, VehicleCat.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Vehicle Category already exist..!");
        }
    }

    public VehicleCatDTO searchVehicleCatDetail(String vehicle_cat_id) {
        Optional<VehicleCat> vehicleCatDetail = repo.findById(vehicle_cat_id);
        if (vehicleCatDetail.isPresent()) {
            return mapper.map(vehicleCatDetail.get(), VehicleCatDTO.class);
        } else {
            throw new RuntimeException("No Vehicle Category for id: " + vehicle_cat_id);
        }
    }

    @Override
    public void updateVehicleCatdetail(VehicleCatDTO dto) {
        if (repo.existsById(dto.getCat_id())) {
            VehicleCat c = mapper.map(dto, VehicleCat.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Invalid Update..!");
        }
    }

    @Override
    public void deleteVehicleCat(String vehicle_cat_id) {
        if (repo.existsById(vehicle_cat_id)) {
            repo.deleteById(vehicle_cat_id);
        } else {
            throw new RuntimeException("No Vehicle Category for delete ID: " + vehicle_cat_id);
        }

    }

    @Override
    public List<VehicleCatDTO> getallVehicleCatList() {
        List<VehicleCat> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<VehicleCat>>() {
        }.getType());
    }
}
