package com.myoluk.controller;

import com.myoluk.dto.UserReviewDto;
import com.myoluk.dto.request.UserReviewSaveRequest;
import com.myoluk.dto.request.UserReviewUpdateRequest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserReviewControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testFindById() {
        ResponseEntity<UserReviewDto> response = restTemplate.getForEntity(
                "/api/v1/user-reviews/3",
                UserReviewDto.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testFindAll() {
        ResponseEntity<List<UserReviewDto>> response = restTemplate.exchange(
                "/api/v1/user-reviews",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    void testUpdate() {
        UserReviewUpdateRequest updateRequest = new UserReviewUpdateRequest(
                5,
                "comment");
        ResponseEntity<UserReviewDto> response = restTemplate.exchange(
                "/api/v1/user-reviews/3",
                HttpMethod.PUT,
                new HttpEntity<>(updateRequest),
                UserReviewDto.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testSave() {
        UserReviewSaveRequest saveRequest = new UserReviewSaveRequest(
                1L,
                "b7b18586-6927-45aa-8a96-d6c09251786f",
                5,
                "comment");
        ResponseEntity<UserReviewDto> response = restTemplate.postForEntity(
                "/api/v1/user-reviews",
                saveRequest,
                UserReviewDto.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

}