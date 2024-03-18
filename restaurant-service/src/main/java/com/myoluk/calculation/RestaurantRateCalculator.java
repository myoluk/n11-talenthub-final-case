package com.myoluk.calculation;

import com.myoluk.entity.Restaurant;

public final class RestaurantRateCalculator {

    private RestaurantRateCalculator() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static double calculateRate(Restaurant restaurant,
                                       double centerLat,
                                       double centerLon,
                                       double radius) {
        int minValue = 0;
        int maxValue = 100;

        double distance = DistanceCalculator.calculateDistance(
                centerLat,
                centerLon,
                restaurant.getLatitude(),
                restaurant.getLongitude()
        );
        double distanceValue = radius / distance;
        double distanceRate = minMaxScaler(distanceValue, minValue, maxValue);

        double scoreRate = minMaxScaler(restaurant.getScore(), minValue, maxValue);

        return (distanceRate * 0.7) + (scoreRate * 0.3);
    }

    private static double minMaxScaler(double value, double minValue, double maxValue) {
        return ((value - minValue) / (maxValue - minValue));
    }
}
