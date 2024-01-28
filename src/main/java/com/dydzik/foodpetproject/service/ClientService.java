package com.dydzik.foodpetproject.service;

import com.dydzik.foodpetproject.dto.ClientResponseDto;
import com.dydzik.foodpetproject.dto.CreateClientDto;
import com.dydzik.foodpetproject.entity.Client;
import com.dydzik.foodpetproject.exception.ClientNotFoundException;
import com.dydzik.foodpetproject.mapper.ClientMapper;
import com.dydzik.foodpetproject.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientService {
	private final ClientRepository clientRepository;
	private final ClientMapper clientMapper;

	public ClientResponseDto create(CreateClientDto dto) {
		Client client = clientMapper.createClientDtoToClient(dto);
		clientRepository.save(client);
		return clientMapper.createClientResponseFromClient(client);
	}

	@Transactional(readOnly = true)
	public Client findById(Long id) {
		return clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
	}

	@Transactional(readOnly = true)
	public Client findByUsername(String username) {
		return clientRepository.findByUsername(username).orElseThrow(ClientNotFoundException::new);
	}

	@Transactional(readOnly = true)
	public List<Client> findAll(int page) {
		return clientRepository.findAll(PageRequest.of(page, 10)).getContent();
	}

	public void deleteById(Long id) {
		Client toDelete = clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
		clientRepository.delete(toDelete);
	}

	public Client updateClientUsernameById(Long id, String username) {
		Client clientToUpdate = clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
		clientToUpdate.setUsername(username);
		clientRepository.save(clientToUpdate);
		return clientToUpdate;
	}
}
