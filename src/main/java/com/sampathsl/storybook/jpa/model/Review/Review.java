package com.sampathsl.storybook.jpa.model.Review;

import com.sampathsl.storybook.jpa.model.BaseEntity;
import com.sampathsl.storybook.jpa.model.user.User;
import com.sampathsl.storybook.jpa.model.project.Project;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public final class Review extends BaseEntity {

	private int rating;
	@NotNull
    @NotBlank(message = "description can't be empty!")
	@Size(min = 2, max = 140)
	private String description;

	@ManyToOne
	private Project project;

    @ManyToOne
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
