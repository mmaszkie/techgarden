package com.techgarden.tasks.geolocation.service;

import com.techgarden.tasks.geolocation.service.entities.model.GeolocationData;
import com.techgarden.tasks.geolocation.service.entities.rest.Circle;
import com.techgarden.tasks.geolocation.service.entities.rest.Geolocation;
import com.techgarden.tasks.geolocation.service.entities.rest.Position;
import com.techgarden.tasks.geolocation.service.repository.GeolocationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/geolocation")
public class GeolocationController {

    private GeolocationDataRepository repository;

    @Autowired
    public GeolocationController(GeolocationDataRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/addData", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public final void addGeolocation(@RequestBody Geolocation data) {
        repository.save(new GeolocationData(data.getName(), point(data.getPosition())));
    }

    @RequestMapping(value = "/getNearbyData", method = RequestMethod.GET)
    public final List<Geolocation> getNearbyGeolocations(@RequestBody Circle circle) {
        Position position = circle.getPosition();
        return repository.findByPointNear(point(position), distanceInKilometers(circle.getDistance())).stream()
                .filter(x -> skipSelf(x.getPoint(), position))
                .map(GeolocationData::DTO)
                .collect(Collectors.toList());
    }

    private Point point(Position position) {
        return new Point(position.getLongitude(), position.getLatitude());
    }

    private Distance distanceInKilometers(double distance) {
        return new Distance(distance, Metrics.KILOMETERS);
    }

    private boolean skipSelf(Point point, Position position) {
        return point.getX() != position.getLongitude() || point.getY() != position.getLatitude();
    }
}