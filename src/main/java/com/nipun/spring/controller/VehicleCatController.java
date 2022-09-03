package com.nipun.spring.controller;


import com.nipun.spring.dto.VehicleCatDTO;
import com.nipun.spring.service.VehicleCatService;
import com.nipun.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/go-cheeta")
@CrossOrigin

public class VehicleCatController {

    @Autowired
    VehicleCatService vehicleCatService;

    @PostMapping("/vehicle_cat/save")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleCatDTO dto) {
        vehicleCatService.addVehicleCat(dto);
        StandradResponse response = new StandradResponse(200, "Vehicle Category Successfully Added", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/vehicle_cat/search/{vehicle_cat}")
    public ResponseEntity<?> searchDriver(@PathVariable String vehicle_cat) {
        VehicleCatDTO vehicleCatDetailDTO = vehicleCatService.searchVehicleCatDetail(vehicle_cat);
        return new ResponseEntity<>(new StandradResponse(200, "Success", vehicleCatDetailDTO), HttpStatus.OK);
    }

    @PutMapping("/vehicle_cat/update")
    public ResponseEntity<?> updateVehicledetail(@RequestBody VehicleCatDTO dto) {
        vehicleCatService.updateVehicleCatdetail(dto);
        return new ResponseEntity<>(new StandradResponse(200, "Vehicle Category Successfuly Updated", null), HttpStatus.OK);
    }

    @DeleteMapping( "/vehicle_cat/delete/{vehicle_cat}")
    public ResponseEntity<?> deleteDriver(@PathVariable String vehicle_cat) {
        vehicleCatService.deleteVehicleCat(vehicle_cat);
        return new ResponseEntity<>(new StandradResponse(200, "Vehicle Successfully Deleted", null), HttpStatus.CREATED);
    }

    @GetMapping("/vehicle_cat/view-all")
    public ResponseEntity<?> getallVehicleList() {
        List<VehicleCatDTO> allVehicleCatList = vehicleCatService.getallVehicleCatList();
        return new ResponseEntity<>(new StandradResponse(200, "Success", allVehicleCatList), HttpStatus.OK);
    }

}
