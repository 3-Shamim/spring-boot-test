package com.learningstuff.springboottest.controllers;

import com.learningstuff.springboottest.dao.TodoClientDao;
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
@RequestMapping(value = "/todos")
public class TodoController {

    private final TodoClientDao todoClientDao;

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<?> getTodoById(@PathVariable(value = "id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(todoClientDao.getTodoById(id));
    }


}
