package com.myoluk.dto.response;

public record RestaurantResponseDto(String id,
                                    String name,
                                    double latitude,
                                    double longitude,
                                    int score) {

}
