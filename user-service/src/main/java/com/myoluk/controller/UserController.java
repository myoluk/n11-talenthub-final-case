package com.myoluk.controller;

import com.myoluk.controller.contract.UserControllerContractImpl;
import com.myoluk.dto.UserDto;
import com.myoluk.dto.request.UserSaveRequest;
import com.myoluk.dto.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserControllerContractImpl userControllerContract;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        UserDto userDto = userControllerContract.findById(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> userDtos = userControllerContract.findAll();
        return ResponseEntity.ok(userDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id,
                                          @RequestBody UserUpdateRequest updateRequest) {
        UserDto userDto = userControllerContract.update(id, updateRequest);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserSaveRequest saveRequest) {
        UserDto userDto = userControllerContract.save(saveRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userControllerContract.delete(id);
        return ResponseEntity.noContent().build();
    }
}
