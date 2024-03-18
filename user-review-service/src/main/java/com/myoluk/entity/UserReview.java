package com.myoluk.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_review")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserReview {

    @SequenceGenerator(name = "UserReview", sequenceName = "user_review_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserReview")
    @Id
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "restaurant_id", nullable = false)
    private String restaurantId;

    @Column(name = "score", nullable = false)
    private int score;

    @Column(name = "comment", length = 150)
    private String comment;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "updateDate")
    private LocalDateTime updateDate;
}
