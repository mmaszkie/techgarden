package com.techgarden.tasks.geolocation.service;

import com.techgarden.tasks.geolocation.service.base.AbstractGeolocationControllerTest;
import com.techgarden.tasks.geolocation.service.entities.rest.Circle;
import com.techgarden.tasks.geolocation.service.entities.rest.Geolocation;
import com.techgarden.tasks.geolocation.service.entities.rest.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class GeolocationControllerPerformanceTest extends AbstractGeolocationControllerTest {

    private static final Logger LOG = LoggerFactory.getLogger(GeolocationControllerPerformanceTest.class);

    private static final int CITIES_NUMBER = 10000;

    private static final int QUERIES_NUMER = 1000;

    private static final double DISTANCE = 100;

    @Autowired
    private GeolocationController controller;

    @Override
    protected void initializeGeolocationDataCollection() {
        LOG.info("Generating and inserting random cities (" + CITIES_NUMBER + ")...");
        for (int i = 0; i < CITIES_NUMBER; i++ ) {
            controller.addGeolocation(randomCity(i));
        }
        LOG.info("Done");
    }

    @Test
    public void shouldRunManyQueries() {
        // given
        long overallExecutionTime = 0;
        long overallCitiesFound = 0;

        // when
        LOG.info("Running queries (" + QUERIES_NUMER + ")..." );
        for (int i = 0; i < QUERIES_NUMER; i++) {
            long startTime = System.currentTimeMillis();
            List<Geolocation> cities = controller.getNearbyGeolocations(geolocationCircle());
            LOG.info("Query " + i + " finished");
            overallExecutionTime += System.currentTimeMillis() - startTime;
            overallCitiesFound += cities.size();
        }
        LOG.info("Done");

        // then
        LOG.info("Overall time for " + QUERIES_NUMER + " queries (ms): " + overallExecutionTime);
        LOG.info("Average query execution time (ms): " + average(overallExecutionTime));
        LOG.info("Average hits per query: " + average(overallCitiesFound));
    }

    private Geolocation randomCity(int index) {
        return new Geolocation(String.valueOf(index), new Position(randomLongitude(), randomLatitude()));
    }

    private Circle geolocationCircle() {
        return new Circle(new Position(randomLongitude(), randomLatitude()), DISTANCE);
    }

    private double randomLongitude() {
        return Math.random() * Math.PI * 2;
    }

    private double randomLatitude() {
        return Math.acos(Math.random() * 2 - 1);
    }

    private double average(double number) {
        return number / QUERIES_NUMER;
    }
}