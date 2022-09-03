package com.nipun.spring.controller;


import com.nipun.spring.dto.VehicleDTO;
import com.nipun.spring.service.VehicleService;
import com.nipun.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/go-cheeta")
@CrossOrigin

public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/vehicle/save")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDTO dto) {
        vehicleService.addVehicle(dto);
        StandradResponse response = new StandradResponse(200, "Vehicle Successfully Added", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/vehicle/search/{vehicle_id}")
    public ResponseEntity<?> searchDriver(@PathVariable String vehicle_id) {
        VehicleDTO vehicleDetailDTO = vehicleService.searchVehicleDetail(vehicle_id);
        return new ResponseEntity<>(new StandradResponse(200, "Success", vehicleDetailDTO), HttpStatus.OK);
    }

    @PutMapping("/vehicle/update")
    public ResponseEntity<?> updateVehicledetail(@RequestBody VehicleDTO dto) {
        vehicleService.updateVehicledetail(dto);
        return new ResponseEntity<>(new StandradResponse(200, "Vehicle Successfuly Updated", null), HttpStatus.OK);
    }

    @DeleteMapping( "/vehicle/delete/{vehicle_id}")
    public ResponseEntity<?> deleteDriver(@PathVariable String vehicle_id) {
        vehicleService.deleteVehicle(vehicle_id);
        return new ResponseEntity<>(new StandradResponse(200, "Vehicle Successfully Deleted", null), HttpStatus.CREATED);
    }

    @GetMapping("/vehicle/view-all")
    public ResponseEntity<?> getallVehicleList() {
        List<VehicleDTO> allVehicleList = vehicleService.getallVehicleList();
        return new ResponseEntity<>(new StandradResponse(200, "Success", allVehicleList), HttpStatus.OK);
    }

}
