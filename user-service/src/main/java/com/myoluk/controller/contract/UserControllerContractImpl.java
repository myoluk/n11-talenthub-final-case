package com.myoluk.controller.contract;

import com.myoluk.dto.UserDto;
import com.myoluk.dto.request.UserSaveRequest;
import com.myoluk.dto.request.UserUpdateRequest;
import com.myoluk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContract {

    private final UserService userService;

    @Override
    public UserDto findById(Long id) {
        return userService.findById(id);
    }

    @Override
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @Override
    public UserDto update(Long id, UserUpdateRequest updateRequest) {
        return userService.update(id, updateRequest);
    }

    @Override
    public UserDto save(UserSaveRequest saveRequest) {
        return userService.save(saveRequest);
    }

    @Override
    public void delete(Long id) {
        userService.deleteById(id);
    }
}
