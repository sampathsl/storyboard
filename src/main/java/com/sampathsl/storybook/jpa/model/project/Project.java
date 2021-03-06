package com.sampathsl.storybook.jpa.model.project;

import com.sampathsl.storybook.jpa.model.BaseEntity;
import com.sampathsl.storybook.jpa.model.Review.Review;
import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public final class Project extends BaseEntity {

    @NotNull
    @NotBlank(message = "title can't be empty!")
    @Size(min = 2, max = 140)
    private String title;
    private int priority;
    @NotNull
    @NotBlank(message = "url can't be empty!")
    @Size(min = 2, max = 140)
    private String url;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Review> reviews;

    protected Project() {
        super();
        reviews = new ArrayList<>();
    }

    public void addReview(Review review) {
        review.setProject(this);
        reviews.add(review);
    }

    public Project(String title, int priority, String url) {
        this();
        this.title = title;
        this.priority = priority;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", priority=" + priority +
                ", url='" + url + '\'' +
                ", reviews=" + reviews +
                '}';
    }

}
