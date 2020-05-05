package com.uncmath25.template.model;

import com.uncmath25.template.park.model.Park;
import com.uncmath25.template.park.model.ParkData;

import static org.junit.Assert.assertEquals;

public class TestUtils {
    public static void assertParksEqual(final Park actualPark,
                                        final Park expectedPark) {
        assertEquals(actualPark.getName(), expectedPark.getName());
        assertEquals(actualPark.getParkType().name(), expectedPark.getParkType().name());
        assertParkDatasEqual(actualPark.getParkData(), expectedPark.getParkData());
    }

    public static void assertParkDatasEqual(final ParkData actualParkData,
                                            final ParkData expectedParkData) {
//        TODO: Implement
    }
}
