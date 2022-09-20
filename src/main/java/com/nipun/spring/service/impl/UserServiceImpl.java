package com.nipun.spring.service.impl;

import com.nipun.spring.dto.UserDTO;
import com.nipun.spring.entity.User;
import com.nipun.spring.repo.UserRepo;
import com.nipun.spring.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private ModelMapper mapper;
    public void addUser(UserDTO dto) {
        if (!repo.existsById(dto.getNic())) {
            User c = mapper.map(dto, User.class);
            repo.save(c);
        } else {
            throw new RuntimeException("User Already exist..!");
        }
    }

    @Override
    public boolean login(String username, String password) {
        if(repo.existsByNic(username)){
            User user = repo.findByNic(username);
            if(user.getPassword().equals(password)){
                return true;
            }else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public UserDTO searchUserDetail(String nic) {
        Optional<User> userDetail = repo.findById(nic);
        if (userDetail.isPresent()) {
            return mapper.map(userDetail.get(), UserDTO.class);
        } else {
            throw new RuntimeException("No User for id: " + nic);
        }
    }


    @Override
    public List<UserDTO> getAllUsers() {
        List<User> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<UserDTO>>() {
        }.getType());
    }

    @Override
    public void updateUserdetail(UserDTO dto) {
        if (repo.existsById(dto.getUser_id())) {
            User c = mapper.map(dto, User.class);
            repo.save(c);
        } else {
            throw new RuntimeException("Invalid Update..!");
        }
    }

    @Override
    public void deleteUserDetail(String nic) {
        if (repo.existsById(nic)) {
            repo.deleteById(nic);
        } else {
            throw new RuntimeException("No User for delete ID: " + nic);
        }

    }

}
