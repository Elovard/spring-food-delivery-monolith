package com.dydzik.foodpetproject.web.controller;

import com.dydzik.foodpetproject.configuration.JwtTokenProvider;
import com.dydzik.foodpetproject.dto.*;
import com.dydzik.foodpetproject.service.BusinessService;
import com.dydzik.foodpetproject.service.ClientService;
import com.dydzik.foodpetproject.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	private final JwtTokenProvider jwtTokenProvider;
	private final ClientService clientService;
	private final CourierService courierService;
	private final BusinessService businessService;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequestDto dto) {
		String token = jwtTokenProvider.generateJwtTokenDependingOnClientType(dto);

		if (token != null) {
			return ResponseEntity.ok(token);
		}
		return ResponseEntity.badRequest().build();
	}

	@PostMapping("/client")
	public ResponseEntity<ClientResponseDto> create(@RequestBody CreateClientDto dto) {
		ClientResponseDto save = clientService.create(dto);
		return new ResponseEntity<>(save, HttpStatus.CREATED);
	}

	@PostMapping("/courier")
	public ResponseEntity<CourierResponseDto> create(@RequestBody CreateCourierDto dto) {
		CourierResponseDto save = courierService.create(dto);
		return new ResponseEntity<>(save, HttpStatus.CREATED);
	}

	@PostMapping("/business")
	public ResponseEntity<BusinessResponseDto> create(@RequestBody CreateBusinessDto dto) {
		BusinessResponseDto save = businessService.create(dto);
		return new ResponseEntity<>(save, HttpStatus.CREATED);
	}
}
