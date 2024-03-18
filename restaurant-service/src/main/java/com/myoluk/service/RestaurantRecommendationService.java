package com.myoluk.service;

import com.myoluk.calculation.DistanceCalculator;
import com.myoluk.calculation.GeographicBoundariesCalculator;
import com.myoluk.calculation.RestaurantRateCalculator;
import com.myoluk.dto.RestaurantDto;
import com.myoluk.entity.Restaurant;
import com.myoluk.mapper.RestaurantMapper;
import com.myoluk.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RestaurantRecommendationService {

    private final RestaurantRepository restaurantRepository;

    public List<RestaurantDto> findRecommendRestaurants(double latitude, double longitude) {
        double recommendationRadius = 10;

        Map<String, Double> boundaries;

        boundaries = GeographicBoundariesCalculator.calculateBoundaries(
                latitude,
                longitude,
                recommendationRadius
        );

        Iterable<Restaurant> restaurants;

        restaurants = restaurantRepository.findRecommendRestaurantsByBoundaries(
                boundaries.get("minLat"),
                boundaries.get("maxLat"),
                boundaries.get("minLon"),
                boundaries.get("maxLon")
        );

        restaurants = getTop3Restaurants(restaurants, latitude, longitude, recommendationRadius);

        return RestaurantMapper.INSTANCE.entitiesToDtos(restaurants);
    }

    private Iterable<Restaurant> getTop3Restaurants(Iterable<Restaurant> restaurants,
                                                    double centerLat,
                                                    double centerLon,
                                                    double radius) {
        Map<Restaurant, Double> topRestaurants = new HashMap<>();

        for (Restaurant restaurant : restaurants) {
            if (isRecommendRestaurantInRange(restaurant, centerLat, centerLon, radius)) {
                double rate = RestaurantRateCalculator.calculateRate(
                        restaurant,
                        centerLat,
                        centerLon,
                        radius
                );
                topRestaurants.put(restaurant, rate);
            }
        }

        PriorityQueue<Map.Entry<Restaurant, Double>> pq = new PriorityQueue<>(
                Map.Entry.comparingByValue(Comparator.reverseOrder())
        );

        for (Map.Entry<Restaurant, Double> entry : topRestaurants.entrySet()) {
            pq.offer(entry);
        }

        List<Restaurant> top3restaurants = new ArrayList<>();
        int maxIter = Math.min(3, pq.size());
        for (int i = 0; i < maxIter; i++) {
            top3restaurants.add(Objects.requireNonNull(pq.poll()).getKey());
        }

        return top3restaurants;
    }

    private boolean isRecommendRestaurantInRange(Restaurant restaurant,
                                                 double centerLat,
                                                 double centerLon,
                                                 double radius) {
        double distance = DistanceCalculator.calculateDistance(
                centerLat,
                centerLon,
                restaurant.getLatitude(),
                restaurant.getLongitude()
        );
        return distance <= radius;
    }



}
