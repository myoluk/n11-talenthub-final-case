package com.myoluk.controller.contract;

import com.myoluk.client.RestaurantRecommendationClient;
import com.myoluk.client.UserClient;
import com.myoluk.dto.response.RestaurantResponseDto;
import com.myoluk.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantRecommendationControllerContractImpl implements RestaurantRecommendationControllerContract {

    private final RestaurantRecommendationClient recommendationClient;

    private final UserClient userClient;

    @Override
    public List<RestaurantResponseDto> findRecommendRestaurantsByUserId(Long userId) {
        UserResponseDto user = userClient.findById(userId);
        return recommendationClient.findRecommendRestaurants(user.latitude(), user.longitude());
    }
}
