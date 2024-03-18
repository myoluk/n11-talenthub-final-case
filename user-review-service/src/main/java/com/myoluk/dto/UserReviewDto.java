package com.myoluk.dto;

import java.time.LocalDateTime;

public record UserReviewDto(Long id,
                            Long userId,
                            String restaurantId,
                            int score,
                            String comment,
                            LocalDateTime createDate,
                            LocalDateTime updateDate) {
}
