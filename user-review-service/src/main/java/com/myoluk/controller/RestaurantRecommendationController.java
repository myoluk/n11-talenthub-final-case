package com.myoluk.controller;

import com.myoluk.controller.contract.RestaurantRecommendationControllerContractImpl;
import com.myoluk.dto.response.RestaurantResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant-recommendations")
@RequiredArgsConstructor
public class RestaurantRecommendationController {

    private  final RestaurantRecommendationControllerContractImpl recommendationControllerContract;

    @GetMapping("/with-user/{userId}")
    public ResponseEntity<List<RestaurantResponseDto>> findRecommendRestaurantsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(recommendationControllerContract
                .findRecommendRestaurantsByUserId(userId));
    }
}
