package com.sampathsl.storybook.jpa.model.Review;

import com.sampathsl.storybook.jpa.model.user.User;
import com.sampathsl.storybook.jpa.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by SAMPATH on 3/21/2017.
 */
@Component
@RepositoryEventHandler(Review.class)
public final class ReviewEventHandler {

    @Autowired
    private UserRepository userRepository;

    @HandleBeforeCreate
    public void addReviewerBasedOnLoggedInUser(Review review) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserName(userName);
        review.setUser(user);
    }

}
