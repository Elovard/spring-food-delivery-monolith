package com.dydzik.foodpetproject.web.controller;

import com.dydzik.foodpetproject.dto.CreateBusinessDto;
import com.dydzik.foodpetproject.entity.Business;
import com.dydzik.foodpetproject.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/business")
@RequiredArgsConstructor
public class BusinessController {

    private final BusinessService businessService;

    @GetMapping
    public ResponseEntity<List<Business>> getAll(@RequestParam int page) {
        return ResponseEntity.ok(businessService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Business> getBusinessById(@PathVariable Long id) {
        return ResponseEntity.ok(businessService.findById(id));
    }

    @GetMapping("/u/{username}")
    public ResponseEntity<Business> getBusinessById(@PathVariable String username) {
        return ResponseEntity.ok(businessService.findByUsername(username));
    }

    @PutMapping("/{id}/{username}")
    public ResponseEntity<Business> updateBusinessUsernameById(@PathVariable Long id, @PathVariable String username) {
        return ResponseEntity.ok(businessService.updateBusinessUsernameById(id, username));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Business> deleteBusinessById(@PathVariable Long id) {
        businessService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
