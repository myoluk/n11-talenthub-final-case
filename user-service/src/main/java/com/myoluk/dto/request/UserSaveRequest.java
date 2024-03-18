package com.myoluk.dto.request;

import com.myoluk.enums.EnumGender;

import java.time.LocalDate;

public record UserSaveRequest(String name,
                              String surname,
                              LocalDate birthDate,
                              EnumGender gender,
                              String email,
                              double latitude,
                              double longitude) {

}
