package com.myoluk.mapper;

import com.myoluk.dto.UserDto;
import com.myoluk.dto.request.UserSaveRequest;
import com.myoluk.dto.request.UserUpdateRequest;
import com.myoluk.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto entityToDto(User user);

    User saveRequestDtoToEntity(UserSaveRequest saveRequest);

    List<UserDto> entitiesToDtos(List<User> users);

    void updateUserFields(@MappingTarget User user, UserUpdateRequest updateRequest);
}
