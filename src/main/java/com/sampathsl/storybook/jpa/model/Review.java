package com.sampathsl.storybook.jpa.model;

import javax.persistence.Entity;

@Entity
public class Review extends BaseEntity {

	private String rating;
	private String description;

	protected Review() {
		super();
	}

	public Review(String rating, String description) {
		this.rating = rating;
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
