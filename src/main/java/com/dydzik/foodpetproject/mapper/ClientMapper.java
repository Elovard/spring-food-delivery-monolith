package com.dydzik.foodpetproject.mapper;

import com.dydzik.foodpetproject.dto.ClientDto;
import com.dydzik.foodpetproject.dto.ClientResponseDto;
import com.dydzik.foodpetproject.dto.CreateClientDto;
import com.dydzik.foodpetproject.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
	Client createDtoFromClient(ClientDto dto);
	Client createClientDtoToClient(CreateClientDto dto);
	ClientResponseDto createClientResponseFromClient(Client client);
}
