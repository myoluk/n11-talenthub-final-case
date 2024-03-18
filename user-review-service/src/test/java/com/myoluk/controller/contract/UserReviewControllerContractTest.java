package com.myoluk.controller.contract;

import com.myoluk.dto.UserReviewDto;
import com.myoluk.dto.request.UserReviewSaveRequest;
import com.myoluk.dto.request.UserReviewUpdateRequest;
import com.myoluk.service.UserReviewService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserReviewControllerContractTest {

    @Mock
    private UserReviewService userReviewService;

    @InjectMocks
    private UserReviewControllerContractImpl userReviewControllerContract;

    @Test
    void findById_ValidId_ReturnsUserReviewDto() {
        Long id = 1L;
        LocalDateTime localDateTime = LocalDateTime.now();
        UserReviewDto expectedDto = new UserReviewDto(
                100L,
                1L,
                "e7932f1b-f3e2-405c-bf86-9afbecb7653e",
                5,
                "comment",
                localDateTime,
                localDateTime
        );
        when(userReviewService.findById(id)).thenReturn(expectedDto);

        UserReviewDto actualDto = userReviewControllerContract.findById(id);

        assertEquals(expectedDto, actualDto);
    }

    @Test
    void findAll_ReturnsUserReviewDtoList() {
        List<UserReviewDto> expectedDtos = new ArrayList<>();
        when(userReviewService.findAll()).thenReturn(expectedDtos);

        List<UserReviewDto> actualDtos = userReviewControllerContract.findAll();

        assertEquals(expectedDtos, actualDtos);
    }

    @Test
    void update_ValidIdAndUpdateRequest_ReturnsUserReviewDto() {
        Long id = 1L;
        LocalDateTime localDateTime = LocalDateTime.now();
        UserReviewUpdateRequest updateRequest = new UserReviewUpdateRequest(5, "comment");
        UserReviewDto expectedDto = new UserReviewDto(
                100L,
                1L,
                "e7932f1b-f3e2-405c-bf86-9afbecb7653e",
                5,
                "comment",
                localDateTime,
                localDateTime
        );
        when(userReviewService.update(id, updateRequest)).thenReturn(expectedDto);

        UserReviewDto actualDto = userReviewControllerContract.update(id, updateRequest);

        assertEquals(expectedDto, actualDto);
    }

    @Test
    void save_ValidRequest_ReturnsSavedUserReviewDto() {
        LocalDateTime localDateTime = LocalDateTime.now();
        UserReviewSaveRequest saveRequest = new UserReviewSaveRequest(
                100L,
                "e7932f1b-f3e2-405c-bf86-9afbecb7653e",
                5,
                "comment"
        );
        UserReviewDto expectedDto = new UserReviewDto(
                100L,
                1L,
                "e7932f1b-f3e2-405c-bf86-9afbecb7653e",
                5,
                "comment",
                localDateTime,
                localDateTime
        );
        when(userReviewService.save(saveRequest)).thenReturn(expectedDto);

        UserReviewDto actualDto = userReviewControllerContract.save(saveRequest);

        assertEquals(expectedDto, actualDto);
    }

    @Test
    void delete_ValidId_Verify() {
        Long id = 1L;

        userReviewControllerContract.delete(id);

        verify(userReviewService).deleteById(id);
    }
}