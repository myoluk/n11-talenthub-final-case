package com.myoluk.service;

import com.myoluk.dto.UserReviewDto;
import com.myoluk.dto.request.UserReviewSaveRequest;
import com.myoluk.dto.request.UserReviewUpdateRequest;
import com.myoluk.entity.UserReview;
import com.myoluk.exception.UserReviewNotFoundException;
import com.myoluk.mapper.UserReviewMapper;
import com.myoluk.repository.UserReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserReviewService {

    private final UserReviewRepository userReviewRepository;

    public UserReviewDto findById(Long id) {
        UserReview userReview = findByIdOptional(id);
        return UserReviewMapper.INSTANCE.entityToDto(userReview);
    }

    public List<UserReviewDto> findAll() {
        List<UserReview> userReviews = userReviewRepository.findAll();
        return UserReviewMapper.INSTANCE.entitiesToDtos(userReviews);
    }

    public UserReviewDto update(Long id, UserReviewUpdateRequest updateRequest) {
        UserReview userReview = findByIdOptional(id);

        UserReviewMapper.INSTANCE.updateUserReviewFields(userReview, updateRequest);

        clampScoreBetweenOneAndFive(userReview);

        LocalDateTime currentTime = LocalDateTime.now();
        userReview.setUpdateDate(currentTime);

        userReview = userReviewRepository.save(userReview);

        return UserReviewMapper.INSTANCE.entityToDto(userReview);
    }

    public UserReviewDto save(UserReviewSaveRequest saveRequest) {
        UserReview userReview = UserReviewMapper.INSTANCE.saveRequestDtoToEntity(saveRequest);

        clampScoreBetweenOneAndFive(userReview);

        LocalDateTime currentTime = LocalDateTime.now();
        userReview.setCreateDate(currentTime);
        userReview.setUpdateDate(currentTime);

        userReview = userReviewRepository.save(userReview);

        return UserReviewMapper.INSTANCE.entityToDto(userReview);
    }

    public void deleteById(Long id) {
        if (!userReviewRepository.existsById(id)) {
            throw new UserReviewNotFoundException("User review not found with id: " + id);
        }
        userReviewRepository.deleteById(id);
    }

    private UserReview findByIdOptional(Long id) {
        Optional<UserReview> optional = userReviewRepository.findById(id);
        UserReview userReview;
        if (optional.isPresent()) {
            userReview = optional.get();
        }
        else {
            throw new UserReviewNotFoundException("User review not found with id: " + id);
        }
        return userReview;
    }

    private void clampScoreBetweenOneAndFive(UserReview userReview) {
        userReview.setScore(
                Math.max(1, Math.min(5, userReview.getScore()))
        );
    }

}
