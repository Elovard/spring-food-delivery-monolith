package com.dydzik.foodpetproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginRequestDto {
	private String username;
	private String password;
	private String type;
}
