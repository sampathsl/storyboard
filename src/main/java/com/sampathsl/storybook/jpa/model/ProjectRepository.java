package com.sampathsl.storybook.jpa.model;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "project", path = "project")
public interface ProjectRepository extends CrudRepository<Project, Long>, PagingAndSortingRepository<Project, Long> {

    @RestResource(rel = "title-contains" , path = "projectTitle")
	Page<Project> findByTitle(@Param("title") String title, Pageable page);
    @RestResource(rel = "priority" , path = "projectPriority")
	Page<Project> findByPriority(@Param("priority") Integer priority, Pageable page);

}
