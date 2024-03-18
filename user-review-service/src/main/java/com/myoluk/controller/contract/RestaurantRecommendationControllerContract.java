package com.myoluk.controller.contract;

import com.myoluk.dto.response.RestaurantResponseDto;

import java.util.List;

public interface RestaurantRecommendationControllerContract {

    List<RestaurantResponseDto> findRecommendRestaurantsByUserId(Long userId);
}
