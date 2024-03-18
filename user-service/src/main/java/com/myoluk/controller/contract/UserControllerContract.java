package com.myoluk.controller.contract;

import com.myoluk.dto.UserDto;
import com.myoluk.dto.request.UserSaveRequest;
import com.myoluk.dto.request.UserUpdateRequest;

import java.util.List;

public interface UserControllerContract {

    UserDto findById(Long id);

    List<UserDto> findAll();

    UserDto update(Long id, UserUpdateRequest updateRequest);

    UserDto save(UserSaveRequest saveRequest);

    void delete(Long id);
}
