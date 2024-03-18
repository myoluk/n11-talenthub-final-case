package com.myoluk.controller;

import com.myoluk.controller.contract.RestaurantRecommendationControllerContractImpl;
import com.myoluk.dto.RestaurantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant-recommendations")
@RequiredArgsConstructor
public class RestaurantRecommendationController {

    private final RestaurantRecommendationControllerContractImpl recommendationControllerContract;

    @GetMapping("/with-location/{latitude},{longitude}")
    public List<RestaurantDto> findRecommendRestaurants(@PathVariable double latitude,
                                                        @PathVariable double longitude) {
        return recommendationControllerContract.findRecommendRestaurants(latitude, longitude);
    }
}
