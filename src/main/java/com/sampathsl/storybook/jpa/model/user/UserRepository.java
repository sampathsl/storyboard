package com.sampathsl.storybook.jpa.model.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by SAMPATH on 3/19/2017.
 */
// disable the /users
@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Long>, PagingAndSortingRepository<User, Long> {

    User findByUserName(String userName);

}
