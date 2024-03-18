package com.myoluk.controller.contract;

import com.myoluk.dto.RestaurantDto;
import com.myoluk.dto.request.RestaurantSaveRequest;
import com.myoluk.dto.request.RestaurantUpdateRequest;
import com.myoluk.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantControllerContractImpl implements RestaurantControllerContract {

    private final RestaurantService restaurantService;

    @Override
    public RestaurantDto findById(String id) {
        return restaurantService.findById(id);
    }

    @Override
    public List<RestaurantDto> findAll() {
        return restaurantService.findAll();
    }

    @Override
    public RestaurantDto update(String id, RestaurantUpdateRequest updateRequest) {
        return restaurantService.update(id, updateRequest);
    }

    @Override
    public RestaurantDto save(RestaurantSaveRequest saveRequest) {
        return restaurantService.save(saveRequest);
    }

    @Override
    public void delete(String id) {
        restaurantService.deleteById(id);
    }
}
