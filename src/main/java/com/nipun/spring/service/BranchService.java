package com.nipun.spring.service;

import com.nipun.spring.dto.BranchDTO;

import java.util.List;

public interface BranchService {
     void addBranch(BranchDTO dto);
     BranchDTO searchBranchDetail(String code);
     List<BranchDTO> getAllBranches();
     void updateBranchdetail(BranchDTO dto);
     void deleteBranchDetail(String nic);

}


