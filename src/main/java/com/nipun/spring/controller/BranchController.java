package com.nipun.spring.controller;

import com.nipun.spring.dto.BranchDTO;
import com.nipun.spring.service.BranchService;
import com.nipun.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/go-cheeta")
@CrossOrigin
public class BranchController {
    @Autowired
    BranchService branchService;

    @PostMapping("/branch/save")
    public ResponseEntity<?> addBranch(@RequestBody BranchDTO dto) {
        branchService.addBranch(dto);
        StandradResponse response = new StandradResponse(200, "Branch successfully added", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/branch/search/{code}")
    public ResponseEntity<?> searchCustomer(@PathVariable String code) {
        BranchDTO branchDetailDTO = branchService.searchBranchDetail(code);
        return new ResponseEntity<>(new StandradResponse(200, "Success", branchDetailDTO), HttpStatus.OK);
    }

    @GetMapping("/branch/view-all")
    public ResponseEntity<?> getAllBranches() {
        List<BranchDTO> allBranchDetails = branchService.getAllBranches();
        return new ResponseEntity<>(new StandradResponse(200, "Success", allBranchDetails), HttpStatus.OK);
    }

    @PutMapping("/branch/update-branch")
    public ResponseEntity<?> updateBranchdetail(@RequestBody BranchDTO dto) {
        branchService.updateBranchdetail(dto);
        return new ResponseEntity<>(new StandradResponse(200, "Branch successfully updated!", null), HttpStatus.OK);
    }

    @DeleteMapping( "/branch/{code}")
    public ResponseEntity<?> deleteBranchDetail(@PathVariable String code) {
        branchService.deleteBranchDetail(code);
        return new ResponseEntity<>(new StandradResponse(200, "Branch successfully deleted!", null), HttpStatus.CREATED);
    }


}
