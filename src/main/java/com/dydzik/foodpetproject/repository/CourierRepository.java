package com.dydzik.foodpetproject.repository;

import com.dydzik.foodpetproject.entity.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {
    Optional<Courier> findByUsername(String username);
}
