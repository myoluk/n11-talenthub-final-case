package com.myoluk.controller.contract;

import com.myoluk.dto.RestaurantDto;

import java.util.List;

public interface RestaurantRecommendationControllerContract {

    List<RestaurantDto> findRecommendRestaurants(double latitude, double longitude);
}
