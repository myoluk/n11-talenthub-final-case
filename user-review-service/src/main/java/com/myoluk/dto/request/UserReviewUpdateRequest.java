package com.myoluk.dto.request;

public record UserReviewUpdateRequest(int score,
                                      String comment) {
}
