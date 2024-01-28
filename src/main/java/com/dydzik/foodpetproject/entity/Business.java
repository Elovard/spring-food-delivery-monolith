package com.dydzik.foodpetproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_business")
public class Business extends AbstractUser {

	@Column(nullable = false)
	private String title;

	@Column(length = 500, nullable = false)
	private String description;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> contacts;

	@OneToMany(mappedBy = "producer")
	@ToString.Exclude
	private List<Order> history;

	@OneToMany
	@ToString.Exclude
	private List<Product> products;

	private double rating;

	//items as Item()
}
