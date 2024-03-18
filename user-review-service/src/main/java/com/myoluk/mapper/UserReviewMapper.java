package com.myoluk.mapper;

import com.myoluk.dto.UserReviewDto;
import com.myoluk.dto.request.UserReviewSaveRequest;
import com.myoluk.dto.request.UserReviewUpdateRequest;
import com.myoluk.entity.UserReview;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserReviewMapper {

    UserReviewMapper INSTANCE = Mappers.getMapper(UserReviewMapper.class);

    UserReviewDto entityToDto(UserReview userReview);

    UserReview saveRequestDtoToEntity(UserReviewSaveRequest saveRequest);

    List<UserReviewDto> entitiesToDtos(List<UserReview> userReviews);

    void updateUserReviewFields(@MappingTarget UserReview userReview, UserReviewUpdateRequest updateRequest);
}
