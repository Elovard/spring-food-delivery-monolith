package com.dydzik.foodpetproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_order")
public class Order extends AuditableEntity {

	private CourierStatus courierStatus;

	private Status status;

	@ToString.Exclude
	@ManyToOne
	private Courier courier;

	@ToString.Exclude
	@ManyToOne
	private Business producer;

	@ToString.Exclude
	@ManyToOne
	private Client consumer;

	enum CourierStatus {
		OPEN,
		CLOSED
	}

	enum Status {
		PREPARATION,
		ON_DELIVERY,
		DELIVERED
	}
}
