package com.myoluk.controller.contract;

import com.myoluk.dto.UserReviewDto;
import com.myoluk.dto.request.UserReviewSaveRequest;
import com.myoluk.dto.request.UserReviewUpdateRequest;

import java.util.List;

public interface UserReviewControllerContract {

    UserReviewDto findById(Long id);

    List<UserReviewDto> findAll();

    UserReviewDto update(Long id, UserReviewUpdateRequest updateRequest);

    UserReviewDto save(UserReviewSaveRequest saveRequest);

    void delete(Long id);
}
