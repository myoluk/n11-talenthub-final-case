package com.myoluk.client;

import com.myoluk.dto.response.RestaurantResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "restaurantRecommendation",
        url = "http://localhost:8082/api/v1/restaurant-recommendations")
public interface RestaurantRecommendationClient {

    @GetMapping("/with-location/{latitude},{longitude}")
    List<RestaurantResponseDto> findRecommendRestaurants(@PathVariable double latitude,
                                                         @PathVariable double longitude);
}
