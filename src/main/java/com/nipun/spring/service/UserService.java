package com.nipun.spring.service;

import com.nipun.spring.dto.UserDTO;

import java.util.List;

public interface UserService {
     void addUser(UserDTO dto);
     UserDTO searchUserDetail(String nic);
     List<UserDTO> getAllUsers();
     void updateUserdetail(UserDTO dto);
     void deleteUserDetail(String nic);
     boolean login(String username, String password);

}


