package com.techgarden.tasks.geolocation.service.entities.model;

import com.techgarden.tasks.geolocation.service.entities.rest.Geolocation;
import com.techgarden.tasks.geolocation.service.entities.rest.Position;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.techgarden.tasks.geolocation.service.entities.model.GeolocationData.COLLECTION_NAME;

@Document(collection = COLLECTION_NAME)
public class GeolocationData {

    public static final String COLLECTION_NAME = "geolocationData";

    public static final String GEOSPATIAL_COLUMN_NAME = "point";

    @Id
    private String id;

    private String name;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private Point point;

    public GeolocationData(String name, Point point) {
        this.name = name;
        this.point = point;
    }

    public Geolocation DTO() {
        return new Geolocation(name, new Position(point.getX(), point.getY()));
    }

    public String getName() {
        return this.name;
    }

    public Point getPoint() {
        return this.point;
    }
}