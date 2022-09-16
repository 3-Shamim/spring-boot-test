package com.learningstuff.springboottest.dao.impl;

import com.learningstuff.springboottest.dao.TodoClientDao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@Slf4j
@Service
@AllArgsConstructor
public class TodoClientDaoImpl implements TodoClientDao {

    private final RestTemplate restTemplate;

    @Override
    public Map<String, Object> getTodoById(long id) {

        String url = "https://jsonplaceholder.typicode.com/todos/{id}";

        try {

            ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    },
                    id
            );

            return response.getBody();
        } catch (RestClientResponseException ex) {
            log.error(ex.getMessage());
            return null;
        }

    }


}
