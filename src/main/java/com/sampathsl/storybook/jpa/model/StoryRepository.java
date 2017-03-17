package com.sampathsl.storybook.jpa.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "story", path = "story")
public interface StoryRepository extends CrudRepository<Story, Long>, PagingAndSortingRepository<Story, Long> {

	List<Story> findByTitle(String title);

}
