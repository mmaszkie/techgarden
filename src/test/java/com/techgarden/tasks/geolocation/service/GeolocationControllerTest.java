package com.techgarden.tasks.geolocation.service;

import com.techgarden.tasks.geolocation.service.base.AbstractGeolocationControllerTest;
import com.techgarden.tasks.geolocation.service.entities.rest.Circle;
import com.techgarden.tasks.geolocation.service.entities.rest.Geolocation;
import com.techgarden.tasks.geolocation.service.entities.rest.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class GeolocationControllerTest extends AbstractGeolocationControllerTest {

    private static final Position NEW_YORK = new Position(-74.005941,40.712784);

    private static final String LOS_ANGELES = "Los Angeles";

    private static final String CHICAGO = "Chicago";

    @Autowired
    private GeolocationController controller;

    @Override
    protected void initializeGeolocationDataCollection() {
        controller.addGeolocation(new Geolocation(LOS_ANGELES, new Position(-118.243685, 34.052234)));
        controller.addGeolocation(new Geolocation(CHICAGO, new Position( -87.629798,41.878114)));
    }

    @Test
    public void shouldNotFindAnyCitiesWhenDistanceIsTooLow() {
        // given/when
        List<Geolocation> cities = controller.getNearbyGeolocations(getGeolocationCircle(NEW_YORK, 500));

        // then
        assertThat(cities.size()).isZero();
    }

    @Test
    public void shouldFindOnlyChicagoWithinGivenDistance() {
        // given/when
        List<Geolocation> cities = controller.getNearbyGeolocations(getGeolocationCircle(NEW_YORK, 2000));

        // then
        assertThat(cities.size()).isOne();
        assertThatCityWasFound(cities, CHICAGO);
    }

    @Test
    public void shouldFindBothLosAngelesAndChicagoWithinGivenDistance() {
        // given/when
        List<Geolocation> cities = controller.getNearbyGeolocations(getGeolocationCircle(NEW_YORK, 5000));

        // then
        assertThat(cities.size()).isEqualTo(2);
        assertThatCityWasFound(cities, CHICAGO);
        assertThatCityWasFound(cities, LOS_ANGELES);
    }

    private Circle getGeolocationCircle(Position position, double distance) {
        return new Circle(position, distance);
    }

    private void assertThatCityWasFound(List<Geolocation> cities, String name) {
        assertThat(cities.stream()
                .map(Geolocation::getName)
                .filter(cityName -> cityName.equals(name))
                .collect(Collectors.toList())
        ).isNotNull();
    }
}