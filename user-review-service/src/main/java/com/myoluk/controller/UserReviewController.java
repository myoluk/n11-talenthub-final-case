package com.myoluk.controller;

import com.myoluk.controller.contract.UserReviewControllerContractImpl;
import com.myoluk.dto.UserReviewDto;
import com.myoluk.dto.request.UserReviewSaveRequest;
import com.myoluk.dto.request.UserReviewUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-reviews")
@RequiredArgsConstructor
public class UserReviewController {

    private final UserReviewControllerContractImpl userReviewControllerContract;

    @GetMapping("/{id}")
    public ResponseEntity<UserReviewDto> findById(@PathVariable Long id) {
        UserReviewDto userReviewDto = userReviewControllerContract.findById(id);
        return ResponseEntity.ok(userReviewDto);
    }

    @GetMapping
    public ResponseEntity<List<UserReviewDto>> findAll() {
        List<UserReviewDto> userReviewDtos = userReviewControllerContract.findAll();
        return ResponseEntity.ok(userReviewDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserReviewDto> update(@PathVariable Long id,
                                                @RequestBody UserReviewUpdateRequest updateRequest) {
        UserReviewDto userReviewDto = userReviewControllerContract.update(id, updateRequest);
        return ResponseEntity.ok(userReviewDto);
    }

    @PostMapping
    public ResponseEntity<UserReviewDto> save(@RequestBody UserReviewSaveRequest saveRequest) {
        UserReviewDto userReviewDto = userReviewControllerContract.save(saveRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userReviewDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userReviewControllerContract.delete(id);
        return ResponseEntity.noContent().build();
    }
}
