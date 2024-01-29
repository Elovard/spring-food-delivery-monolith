package com.dydzik.foodpetproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorResponse {
	private String timestamp;
	private String status;
	private String code;
	private String message;
}
