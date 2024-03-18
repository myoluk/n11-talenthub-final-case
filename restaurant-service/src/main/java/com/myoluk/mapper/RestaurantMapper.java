package com.myoluk.mapper;

import com.myoluk.dto.RestaurantDto;
import com.myoluk.dto.request.RestaurantUpdateRequest;
import com.myoluk.entity.Restaurant;
import com.myoluk.dto.request.RestaurantSaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDto entityToDto(Restaurant restaurant);

    Restaurant saveRequestDtoToEntity(RestaurantSaveRequest saveRequest);

    List<RestaurantDto> entitiesToDtos(Iterable<Restaurant> restaurants);

    void updateRestaurantFields(@MappingTarget Restaurant restaurant, RestaurantUpdateRequest updateRequest);
}
