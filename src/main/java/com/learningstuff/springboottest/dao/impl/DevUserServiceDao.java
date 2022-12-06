package com.learningstuff.springboottest.dao.impl;

import com.learningstuff.springboottest.dao.UserServiceDao;
import com.learningstuff.springboottest.models.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@Slf4j
@Service
@AllArgsConstructor
@Profile("dev")
public class DevUserServiceDao implements UserServiceDao {

    @Override
    public List<User> users() {
        log.info("This resource serve from dev user-service");
        return Arrays.asList(
                new User(100, "Mock User 100", LocalDate.now(), LocalDateTime.now()),
                new User(101, "Mock User 101", LocalDate.now(), LocalDateTime.now())
        );
    }

    @Override
    public User save(User user) {
        log.info("This resource serve from dev user-service");
        return new User(100, "Mock User 100", LocalDate.now(), LocalDateTime.now());
    }

}
