package com.sampathsl.storybook.jpa.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Version
    private Long version;

	protected BaseEntity() {}

}
