package com.epiis.app.generic;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityGeneric {
	@Column(name = "createdAt")
	private Timestamp createdAt;
	
	@Column(name = "updatedAt")
	private Timestamp updatedAt;
}
