package com.dydzik.foodpetproject.web.controller;

import com.dydzik.foodpetproject.dto.CreateCourierDto;
import com.dydzik.foodpetproject.entity.Courier;
import com.dydzik.foodpetproject.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courier")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;

    @GetMapping
    public ResponseEntity<List<Courier>> getAllCouriers(@RequestParam int page) {
        return ResponseEntity.ok(courierService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Courier> getCourierById(@PathVariable Long id) {
        return ResponseEntity.ok(courierService.findById(id));
    }

    @GetMapping("/u/{username}")
    public ResponseEntity<Courier> getCourierById(@PathVariable String username) {
        return ResponseEntity.ok(courierService.findByUsername(username));
    }

    @PutMapping("/{id}/{username}")
    public ResponseEntity<Courier> updateCourierUsernameById(@PathVariable Long id, @PathVariable String username) {
        return ResponseEntity.ok(courierService.updateCourierUsernameById(id, username));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Courier> deleteCourierById(@PathVariable Long id) {
        courierService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
