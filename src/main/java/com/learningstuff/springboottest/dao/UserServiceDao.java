package com.learningstuff.springboottest.dao;

import com.learningstuff.springboottest.models.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

public interface UserServiceDao {

    public List<User> users();

    public User save(User user);

}
