package com.myoluk.calculation;

import java.util.HashMap;
import java.util.Map;

public final class GeographicBoundariesCalculator {

    private GeographicBoundariesCalculator() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // Method to calculate the boundaries of a circular area
    // with the given center coordinates and radius
    public static Map<String, Double> calculateBoundaries(double centerLat,
                                                          double centerLon,
                                                          double radius) {
        Map<String, Double> boundaries = new HashMap<>();
        double earthRadius = 6371.0; // Earth radius in kilometers

        // Convert latitude and longitude from degrees to radians
        double radCenterLat = Math.toRadians(centerLat);
        double radCenterLon = Math.toRadians(centerLon);

        // Convert radius from kilometers to radians
        double radRadius = radius / earthRadius;

        // Calculate the boundaries
        double maxLat = Math.toDegrees(radCenterLat + radRadius);
        double minLat = Math.toDegrees(radCenterLat - radRadius);
        double maxLon = Math.toDegrees(radCenterLon + radRadius / Math.cos(radCenterLat));
        double minLon = Math.toDegrees(radCenterLon - radRadius / Math.cos(radCenterLat));

        boundaries.put("maxLat", maxLat);
        boundaries.put("minLat", minLat);
        boundaries.put("maxLon", maxLon);
        boundaries.put("minLon", minLon);

        return boundaries;
    }
}
