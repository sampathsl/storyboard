package com.sampathsl.storybook.jpa.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Review extends BaseEntity {

	private int rating;
	private String description;
	@ManyToOne
	private Project project;

	protected Review() {
		super();
	}

	public Review(int rating, String description) {
		this.rating = rating;
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project story) {
		this.project = story;
	}

}
