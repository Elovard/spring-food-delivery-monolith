package com.dydzik.foodpetproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CreateClientDto {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String phoneNumber;
}
