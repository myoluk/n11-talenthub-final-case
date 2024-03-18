package com.myoluk.service;

import com.myoluk.dto.RestaurantDto;
import com.myoluk.dto.request.RestaurantSaveRequest;
import com.myoluk.dto.request.RestaurantUpdateRequest;
import com.myoluk.entity.Restaurant;
import com.myoluk.exception.RestaurantNotFoundException;
import com.myoluk.mapper.RestaurantMapper;
import com.myoluk.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantDto findById(String id) {
        Restaurant restaurant = findByIdOptional(id);
        return RestaurantMapper.INSTANCE.entityToDto(restaurant);
    }

    public List<RestaurantDto> findAll() {
        Iterable<Restaurant> restaurants = restaurantRepository.findAll();
        return RestaurantMapper.INSTANCE.entitiesToDtos(restaurants);
    }

    public RestaurantDto update(String id, RestaurantUpdateRequest updateRequest) {
        Restaurant restaurant = findByIdOptional(id);

        RestaurantMapper.INSTANCE.updateRestaurantFields(restaurant, updateRequest);

        restaurant = restaurantRepository.save(restaurant);

        return RestaurantMapper.INSTANCE.entityToDto(restaurant);
    }

    public RestaurantDto save(RestaurantSaveRequest saveRequest) {
        Restaurant restaurant = RestaurantMapper.INSTANCE.saveRequestDtoToEntity(saveRequest);
        restaurant = restaurantRepository.save(restaurant);
        return RestaurantMapper.INSTANCE.entityToDto(restaurant);
    }

    public void deleteById(String id) {
        if (!restaurantRepository.existsById(id)) {
            throw new RestaurantNotFoundException("Restaurant not found with id: " + id);
        }
        restaurantRepository.deleteById(id);
    }

    private Restaurant findByIdOptional(String id) {
        Optional<Restaurant> optional = restaurantRepository.findById(id);
        Restaurant restaurant;
        if (optional.isPresent()) {
            restaurant = optional.get();
        } else {
            throw new RestaurantNotFoundException("Restaurant not found with id: " + id);
        }
        return restaurant;
    }

}
