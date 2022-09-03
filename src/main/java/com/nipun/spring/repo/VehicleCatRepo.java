package com.nipun.spring.repo;

import com.nipun.spring.entity.VehicleCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCatRepo extends JpaRepository<VehicleCat, String> {

}
