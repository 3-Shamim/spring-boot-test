package com.learningstuff.springboottest.controllers;

import com.learningstuff.springboottest.dao.UserServiceDao;
import com.learningstuff.springboottest.models.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserServiceDao userServiceDao;

    @GetMapping(value = "")
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userServiceDao.users());
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody @Valid User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userServiceDao.save(user));
    }


}
