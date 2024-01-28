package com.dydzik.foodpetproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity extends AbstractEntity {
	@Column(name = "created_date", nullable = false, updatable = false)
	@CreatedDate
	private long createdDate;

	@Column(name = "modified_date")
	@LastModifiedDate
	private long modifiedDate;
}
