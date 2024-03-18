package com.myoluk.dto;

public record RestaurantDto(String id,
                            String name,
                            double latitude,
                            double longitude,
                            int score) {
}
