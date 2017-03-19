package com.sampathsl.storybook.jpa.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by SAMPATH on 3/19/2017.
 */
@Component
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null)
            throw new UsernameNotFoundException(username + "was not founds");
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassWord(), AuthorityUtils.createAuthorityList(user.getRoles()));
    }

}
