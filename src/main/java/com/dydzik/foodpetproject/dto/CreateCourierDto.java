package com.dydzik.foodpetproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCourierDto {
    private String name;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
}
