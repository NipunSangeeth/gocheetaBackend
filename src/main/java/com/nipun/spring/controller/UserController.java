package com.nipun.spring.controller;

import com.nipun.spring.dto.UserDTO;
import com.nipun.spring.service.UserService;
import com.nipun.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/go-cheeta")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userservice;

    @PostMapping("/user/save")
    public ResponseEntity<?> addCustomer(@RequestBody UserDTO dto) {
        userservice.addUser(dto);
        StandradResponse response = new StandradResponse(200, "User successfully added", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody UserDTO dto) {
//        userservice.login(dto);
//        StandradResponse response = new StandradResponse(200, "Successfully Logged", null);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }

    @GetMapping(path = "/user/search/{nic}")
    public ResponseEntity<?> searchCustomer(@PathVariable String nic) {
        UserDTO custDetailDTO = userservice.searchUserDetail(nic);
        return new ResponseEntity<>(new StandradResponse(200, "Success", custDetailDTO), HttpStatus.OK);
    }

    @GetMapping("/user/view-cust")
    public ResponseEntity<?> allCustDetails() {
        List<UserDTO> allCustomerDetails = userservice.getAllUsers();
        return new ResponseEntity<>(new StandradResponse(200, "Success", allCustomerDetails), HttpStatus.OK);
    }

    @PutMapping("/user/update-cust")
    public ResponseEntity<?> updateCustdetail(@RequestBody UserDTO dto) {
        userservice.updateUserdetail(dto);
        return new ResponseEntity<>(new StandradResponse(200, "User successfully updated!", null), HttpStatus.OK);
    }

    @DeleteMapping( "/user/{nic}")
    public ResponseEntity<?> deleteCustomerDetail(@PathVariable String nic) {
        userservice.deleteUserDetail(nic);
        return new ResponseEntity<>(new StandradResponse(200, "User successfully deleted!", null), HttpStatus.CREATED);
    }


}
