package com.dydzik.foodpetproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_client")
public class Client extends AbstractUser {
	private String firstName;
	private String lastName;
	private double rating;

	@OneToMany(mappedBy = "consumer")
	@ToString.Exclude
	private List<Order> history;

	//delivery address mb List<Address>
	//rating

}
