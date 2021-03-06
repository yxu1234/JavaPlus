package com.yishan.javaplus.extend.security;


import com.yishan.javaplus.domain.Authority;
import com.yishan.javaplus.domain.User;
import com.yishan.javaplus.service.AuthorityService;
import com.yishan.javaplus.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;


    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.debug("Loading users by usernames!");

        User user = null;

        try {
            user = userService.findByUsername(username);
            List<Authority> authorities = authorityService.findAuthorityByUser(user);
            user.setAuthorities(authorities);
        }
        catch (Exception e){
            logger.error("catch AuthenticationServiceException from AuthenticationProvider", e);
        }

        return user;
    }


}