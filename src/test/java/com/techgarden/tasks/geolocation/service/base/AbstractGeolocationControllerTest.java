package com.techgarden.tasks.geolocation.service.base;

import com.techgarden.tasks.geolocation.service.entities.model.GeolocationData;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public abstract class AbstractGeolocationControllerTest {

    @Autowired
    protected MongoTemplate template;

    private void setupGeospatialIndex() {
        GeospatialIndex index = new GeospatialIndex(GeolocationData.GEOSPATIAL_COLUMN_NAME).typed(GeoSpatialIndexType.GEO_2DSPHERE);
        template.indexOps(GeolocationData.class).ensureIndex(index);
    }

    private void recreateGeolocationDataCollection() {
        template.dropCollection(GeolocationData.COLLECTION_NAME);
        template.createCollection(GeolocationData.COLLECTION_NAME);
    }

    protected abstract void initializeGeolocationDataCollection();

    @Before
    public void before() {
        recreateGeolocationDataCollection();
        setupGeospatialIndex();
        initializeGeolocationDataCollection();
    }
}