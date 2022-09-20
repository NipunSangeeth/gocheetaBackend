package com.nipun.spring.repo;

import com.nipun.spring.entity.Driver;
import com.nipun.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepo extends JpaRepository<Driver, String> {
    boolean existsByNic(String nic);
    Driver findByNic(String nic);
}
