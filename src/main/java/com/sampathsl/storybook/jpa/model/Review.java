package com.sampathsl.storybook.jpa.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Review extends BaseEntity {

	private int rating;
	@NotNull
    @NotBlank(message = "description can't be empty!")
	@Size(min = 2, max = 140)
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
