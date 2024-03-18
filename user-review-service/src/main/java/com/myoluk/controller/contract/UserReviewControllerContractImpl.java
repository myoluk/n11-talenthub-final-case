package com.myoluk.controller.contract;

import com.myoluk.dto.UserReviewDto;
import com.myoluk.dto.request.UserReviewSaveRequest;
import com.myoluk.dto.request.UserReviewUpdateRequest;
import com.myoluk.service.UserReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserReviewControllerContractImpl implements UserReviewControllerContract {

    private final UserReviewService userReviewService;

    @Override
    public UserReviewDto findById(Long id) {
        return userReviewService.findById(id);
    }

    @Override
    public List<UserReviewDto> findAll() {
        return userReviewService.findAll();
    }

    @Override
    public UserReviewDto update(Long id, UserReviewUpdateRequest updateRequest) {
        return userReviewService.update(id, updateRequest);
    }

    @Override
    public UserReviewDto save(UserReviewSaveRequest saveRequest) {
        return userReviewService.save(saveRequest);
    }

    @Override
    public void delete(Long id) {
        userReviewService.deleteById(id);
    }
}
