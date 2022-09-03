package com.nipun.spring.service.impl;

import com.nipun.spring.dto.BranchDTO;
import com.nipun.spring.dto.UserDTO;
import com.nipun.spring.entity.Branch;
import com.nipun.spring.entity.User;
import com.nipun.spring.repo.BranchRepo;
import com.nipun.spring.service.BranchService;
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
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepo repo;

    @Autowired
    private ModelMapper mapper;
    public void addBranch(BranchDTO dto) {
        if (!repo.existsById(dto.getName())) {
            Branch c = mapper.map(dto, Branch.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Branch Already exist..!");
        }
    }

    @Override
    public BranchDTO searchBranchDetail(String code) {
        Optional<Branch> branchDetail = repo.findById(code);
        if (branchDetail.isPresent()) {
            return mapper.map(branchDetail.get(), BranchDTO.class);
        } else {
            throw new RuntimeException("No Branch for Code: " + code);
        }
    }

    @Override
    public List<BranchDTO> getAllBranches() {
        List<Branch> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<BranchDTO>>() {
        }.getType());
    }

    @Override
    public void updateBranchdetail(BranchDTO dto) {
        if (repo.existsById(dto.getName())) {
            Branch c = mapper.map(dto, Branch.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Invalid Update..!");
        }
    }

    @Override
    public void deleteBranchDetail(String code) {
        if (repo.existsById(code)) {
            repo.deleteById(code);
        } else {
            throw new RuntimeException("No Branch for delete Code: " + code);
        }

    }

}
