package com.techgarden.tasks.geolocation.service.repository;

import com.techgarden.tasks.geolocation.service.entities.model.GeolocationData;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GeolocationDataRepository extends MongoRepository<GeolocationData, String> {

    List<GeolocationData> findByPointNear(Point point, Distance maxDistance);

}