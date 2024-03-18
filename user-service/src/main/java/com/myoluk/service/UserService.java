package com.myoluk.service;

import com.myoluk.dto.UserDto;
import com.myoluk.dto.request.UserSaveRequest;
import com.myoluk.dto.request.UserUpdateRequest;
import com.myoluk.entity.User;
import com.myoluk.exception.UserNotFoundException;
import com.myoluk.mapper.UserMapper;
import com.myoluk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto findById(Long id) {
        User user = findByIdOptional(id);
        return UserMapper.INSTANCE.entityToDto(user);
    }

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return UserMapper.INSTANCE.entitiesToDtos(users);
    }

    public UserDto update(Long id, UserUpdateRequest updateRequest) {
        User user = findByIdOptional(id);

        UserMapper.INSTANCE.updateUserFields(user, updateRequest);

        LocalDateTime currentTime = LocalDateTime.now();
        user.setUpdateDate(currentTime);

        user = userRepository.save(user);

        return UserMapper.INSTANCE.entityToDto(user);
    }

    public UserDto save(UserSaveRequest saveRequest) {
        User user = UserMapper.INSTANCE.saveRequestDtoToEntity(saveRequest);

        LocalDateTime currentTime = LocalDateTime.now();
        user.setCreateDate(currentTime);
        user.setUpdateDate(currentTime);

        user = userRepository.save(user);

        return UserMapper.INSTANCE.entityToDto(user);
    }

    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    private User findByIdOptional(Long id) {
        Optional<User> optional = userRepository.findById(id);
        User user;
        if (optional.isPresent()) {
            user = optional.get();
        }
        else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
        return user;
    }
}
