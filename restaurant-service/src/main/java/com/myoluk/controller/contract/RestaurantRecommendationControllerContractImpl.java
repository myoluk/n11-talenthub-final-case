package com.myoluk.controller.contract;

import com.myoluk.dto.RestaurantDto;
import com.myoluk.service.RestaurantRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantRecommendationControllerContractImpl implements RestaurantRecommendationControllerContract {

    private final RestaurantRecommendationService recommendationService;

    @Override
    public List<RestaurantDto> findRecommendRestaurants(double latitude, double longitude) {
        return recommendationService.findRecommendRestaurants(latitude, longitude);
    }
}
