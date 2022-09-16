package com.learningstuff.springboottest;

import com.learningstuff.springboottest.dao.impl.TodoClientDaoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@SpringBootTest
public class TodoClientDaoTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private TodoClientDaoImpl todoClientDao;

    @Test
    public void getUserById() {

        Map<String, Object> _res = new HashMap<>() {{
            put("userId", -1);
            put("id", 1);
            put("title", "Mock Todo");
            put("competed", true);
        }};

        long id = 1;

        String url = "https://jsonplaceholder.typicode.com/todos/{id}";

        Mockito.when(restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, Object>>() {
                }, // ParameterizedTypeReference<Map<String, Object>> is important
                id
        )).thenReturn(new ResponseEntity<>(_res, HttpStatus.OK));

        Map<String, Object> res = todoClientDao.getTodoById(1);

        Assertions.assertEquals("Mock Todo", res.get("title"));
        Assertions.assertEquals(-1, res.get("userId"));

    }


}
