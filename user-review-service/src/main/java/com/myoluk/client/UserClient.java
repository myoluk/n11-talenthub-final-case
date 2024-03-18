package com.myoluk.client;

import com.myoluk.dto.response.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user", url = "http://localhost:8081/api/v1/users")
public interface UserClient {

    @GetMapping("/{id}")
    UserResponseDto findById(@PathVariable Long id);
}
