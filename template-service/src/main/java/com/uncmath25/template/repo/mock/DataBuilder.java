package com.uncmath25.template.repo.mock;

import com.uncmath25.template.park.model.Park;
import com.uncmath25.template.park.model.ZooData;
import com.uncmath25.template.park.model.enums.ParkType;

public class DataBuilder {
    public static Park buildPark(final String name) {
        return new Park(name, ParkType.ZOO, buildZooData());
    }

    private static ZooData buildZooData() {
        return null;
    }
}
