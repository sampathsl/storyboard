package com.sampathsl.storybook.jpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Project extends BaseEntity {

    private String title;
    private int priority;
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
