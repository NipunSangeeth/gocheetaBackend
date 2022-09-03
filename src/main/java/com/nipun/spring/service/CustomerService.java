package com.nipun.spring.service;

import com.nipun.spring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
     void addCustomer(CustomerDTO dto);
     void login(CustomerDTO dto);
     CustomerDTO searchCustDetail(String nic);
     List<CustomerDTO> getAllCustDet();
     void updateCustdetail(CustomerDTO dto);
     void deleteCustomerDetail(String nic);

}


