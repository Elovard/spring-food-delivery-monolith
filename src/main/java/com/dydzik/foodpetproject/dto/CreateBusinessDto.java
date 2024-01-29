package com.dydzik.foodpetproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CreateBusinessDto {
    private String title;
    private String description;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
}
