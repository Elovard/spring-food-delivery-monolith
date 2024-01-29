package com.dydzik.foodpetproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_courier")
public class Courier extends AbstractUser {
	private String name;

	private double rating;

	private String transport;

	@OneToMany(mappedBy = "courier")
	@ToString.Exclude
	private List<Order> history;
}
