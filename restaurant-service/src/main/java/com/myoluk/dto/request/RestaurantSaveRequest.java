package com.myoluk.dto.request;

public record RestaurantSaveRequest(String name,
                                    int score,
                                    double latitude,
                                    double longitude) {
}
