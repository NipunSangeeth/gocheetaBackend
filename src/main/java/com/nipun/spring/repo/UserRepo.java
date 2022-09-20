package com.nipun.spring.repo;

import com.nipun.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    boolean existsByNic(String nic);
    User findByNic(String nic);

}