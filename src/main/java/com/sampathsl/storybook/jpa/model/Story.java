package com.sampathsl.storybook.jpa.model;

import javax.persistence.Entity;

@Entity
public class Story extends BaseEntity {

	private String title;
	private String url;

	protected Story() {
		super();
	}

	public Story(String title, String url) {
		this.title = title;
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

	@Override
	public String toString() {
		return "Story [title=" + title + ", url=" + url + "]";
	}

}
