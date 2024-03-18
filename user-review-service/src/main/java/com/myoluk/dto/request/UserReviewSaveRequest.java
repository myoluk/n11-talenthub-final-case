package com.myoluk.dto.request;

public record UserReviewSaveRequest(Long userId,
                                    String restaurantId,
                                    int score,
                                    String comment) {
}
