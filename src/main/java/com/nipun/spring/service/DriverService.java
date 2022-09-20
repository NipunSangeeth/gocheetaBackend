package com.nipun.spring.service;

import com.nipun.spring.dto.CustomerDTO;
import com.nipun.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void  addDriver(DriverDTO dto);
    DriverDTO searchDriverDetail (String driver_id);
    void updateDriverdetail(DriverDTO dto);
    void deleteDriver(String driver_id);
    List<DriverDTO> getallDriverList();
    boolean login(String username, String password);

}
