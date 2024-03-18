package com.myoluk.repository;

import com.myoluk.entity.Restaurant;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface RestaurantRepository extends SolrCrudRepository<Restaurant, String> {

    @Query("latitude:[?0 TO ?1] AND longitude:[?2 TO ?3]")
    Iterable<Restaurant> findRecommendRestaurantsByBoundaries(double minLat,
                                                          double maxLat,
                                                          double minLon,
                                                          double maxLon);
}
