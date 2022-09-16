package com.learningstuff.springboottest.services;

import com.learningstuff.springboottest.models.User;
import com.learningstuff.springboottest.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> users() {
        return userRepository.findAll();
    }

    public User userById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

}
