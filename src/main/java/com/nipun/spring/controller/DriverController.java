package com.nipun.spring.controller;


import com.nipun.spring.dto.CustomerDTO;
import com.nipun.spring.dto.DriverDTO;
import com.nipun.spring.service.DriverService;
import com.nipun.spring.utill.StandradResponse;
import com.nipun.spring.utill.StandradResponse;
import com.nipun.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/go-cheeta")
@CrossOrigin

public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/driver/save")
    public ResponseEntity<?> addDriver(@RequestBody DriverDTO dto) {
        driverService.addDriver(dto);
        StandradResponse response = new StandradResponse(200, "Successfully Added", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/driver/login")
    public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        boolean isLoged = driverService.login(username,password);
        return new ResponseEntity<>(isLoged, HttpStatus.OK);
    }


    @GetMapping(path = "/driver/search/{driver_id}")
    public ResponseEntity<?> searchDriver(@PathVariable String driver_id) {
        DriverDTO driverDetailDTO = driverService.searchDriverDetail(driver_id);
        return new ResponseEntity<>(new StandradResponse(200, "Success", driverDetailDTO), HttpStatus.OK);
    }

    @PutMapping("/driver/update")
    public ResponseEntity<?> updateDriverdetail(@RequestBody DriverDTO dto) {
        driverService.updateDriverdetail(dto);
        return new ResponseEntity<>(new StandradResponse(200, "Driver Successfuly Updated", null), HttpStatus.OK);
    }

    @DeleteMapping( "/driver/delete/{driver_id}")
    public ResponseEntity<?> deleteDriver(@PathVariable String driver_id) {
        driverService.deleteDriver(driver_id);
        return new ResponseEntity<>(new StandradResponse(200, "Driver Successfully Deleted", null), HttpStatus.CREATED);
    }

    @GetMapping("/driver/view-all")
    public ResponseEntity<?> allDriverList() {
        List<DriverDTO> allDriverList = driverService.getallDriverList();
        return new ResponseEntity<>(new StandradResponse(200, "Success", allDriverList), HttpStatus.OK);
    }

}
