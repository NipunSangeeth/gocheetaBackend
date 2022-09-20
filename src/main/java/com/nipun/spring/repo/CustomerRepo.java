package com.nipun.spring.repo;

import com.nipun.spring.entity.Customer;
import com.nipun.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {
    boolean existsByNic(String nic);
    Customer findByNic(String nic);
}