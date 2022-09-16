package com.learningstuff.springboottest;

import com.learningstuff.springboottest.models.User;
import com.learningstuff.springboottest.repositories.UserRepository;
import com.learningstuff.springboottest.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void getAllUser() {
        Mockito.when(userRepository.findAll()).thenReturn(Arrays.asList(new User(1, "Mock User1"), new User(2, "Mock User2")));
        Assertions.assertEquals(2, userService.users().size());
    }

    @Test
    public void getUserById() {
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(new User(1, "Mock User1")));
        Assertions.assertEquals("Mock User1", userService.userById(1L).getName());
    }

    @Test
    public void save() {
        User user = new User(1, "Mock User1");
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assertions.assertEquals(user, userService.save(user));
        Assertions.assertEquals("Mock User1", userService.save(user).getName());
    }

    @Test
    public void delete() {
        User user = new User(1, "Mock User1");
        userRepository.delete(user);
        Mockito.verify(userRepository, Mockito.times(1)).delete(user);
    }

}
