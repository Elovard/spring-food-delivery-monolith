package com.dydzik.foodpetproject.configuration.principal;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserPrincipal {
	private String username;
	private String email;
	private Type type;

	public enum Type {
		CLIENT,
		BUSINESS,
		COURIER
	}
}
