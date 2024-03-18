package com.myoluk.dto.response;

import com.myoluk.enums.EnumGender;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserResponseDto(Long id,
                              String name,
                              String surname,
                              LocalDate birthDate,
                              EnumGender gender,
                              String email,
                              double latitude,
                              double longitude,
                              LocalDateTime createDate,
                              LocalDateTime updateDate) {
}
