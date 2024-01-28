package com.dydzik.foodpetproject.web.controller;

import com.dydzik.foodpetproject.entity.Client;
import com.dydzik.foodpetproject.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

	private final ClientService clientService;

	@GetMapping
	public ResponseEntity<List<Client>> getAll(@RequestParam int page) {
		return ResponseEntity.ok(clientService.findAll(page));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable Long id) {
		return ResponseEntity.ok(clientService.findById(id));
	}

	@GetMapping("/u/{username}")
	public ResponseEntity<Client> getClientByUsername(@PathVariable String username) {
		return ResponseEntity.ok(clientService.findByUsername(username));
	}


	@PutMapping("/{id}/{username}")
	public ResponseEntity<Client> updateClientUsernameById(@PathVariable Long id, @PathVariable String username) {
		return ResponseEntity.ok(clientService.updateClientUsernameById(id, username));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Client> deleteClientById(@PathVariable Long id) {
		clientService.deleteById(id);
		return ResponseEntity.ok(null);
	}
}
