package com.learningstuff.springboottest.dao.impl;

import com.learningstuff.springboottest.dao.UserServiceDao;
import com.learningstuff.springboottest.models.User;
import com.learningstuff.springboottest.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@Slf4j
@Service
@AllArgsConstructor
@Profile("prod")
public class ProdUserServiceDao implements UserServiceDao {

    private final UserRepository userRepository;

    @Override
    public List<User> users() {
        log.info("This resource serve from prod user-service");
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        log.info("This resource serve from prod user-service");
        return userRepository.save(user);
    }

}
