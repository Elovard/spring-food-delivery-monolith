package com.dydzik.foodpetproject.repository;

import com.dydzik.foodpetproject.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
    Optional<Business> findByUsername(String username);
}
