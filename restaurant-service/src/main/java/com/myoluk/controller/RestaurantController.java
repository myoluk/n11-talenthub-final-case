package com.myoluk.controller;

import com.myoluk.controller.contract.RestaurantControllerContractImpl;
import com.myoluk.dto.RestaurantDto;
import com.myoluk.dto.request.RestaurantSaveRequest;
import com.myoluk.dto.request.RestaurantUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantControllerContractImpl restaurantControllerContract;

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> findById(@PathVariable String id) {
        RestaurantDto restaurantDto = restaurantControllerContract.findById(id);
        return ResponseEntity.ok(restaurantDto);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> findAll() {
        List<RestaurantDto> restaurantDtos = restaurantControllerContract.findAll();
        return ResponseEntity.ok(restaurantDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDto> update(@PathVariable String id,
                                                @RequestBody RestaurantUpdateRequest updateRequest) {
        RestaurantDto restaurantDto = restaurantControllerContract.update(id, updateRequest);
        return ResponseEntity.ok(restaurantDto);
    }

    @PostMapping
    public ResponseEntity<RestaurantDto> save(@RequestBody RestaurantSaveRequest saveRequest) {
        RestaurantDto savedRestaurantDto = restaurantControllerContract.save(saveRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRestaurantDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        restaurantControllerContract.delete(id);
        return ResponseEntity.noContent().build();
    }
}
