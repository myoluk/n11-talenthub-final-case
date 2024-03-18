package com.myoluk.controller.contract;

import com.myoluk.dto.RestaurantDto;
import com.myoluk.dto.request.RestaurantSaveRequest;
import com.myoluk.dto.request.RestaurantUpdateRequest;

import java.util.List;

public interface RestaurantControllerContract {

    RestaurantDto findById(String id);

    List<RestaurantDto> findAll();

    RestaurantDto update(String id, RestaurantUpdateRequest updateRequest);

    RestaurantDto save(RestaurantSaveRequest saveRequest);

    void delete(String id);
}
