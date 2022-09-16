package com.learningstuff.springboottest.dao;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

public interface TodoClientDao {

    public Map<String, Object> getTodoById(long id);

}
