package com.uncmath25.template.park.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.uncmath25.template.park.model.enums.ParkType;

public class Park {
    private String name;
    private ParkType parkType;
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
            property = "parkType",
            defaultImpl = ParkType.class,
            visible = true
    )
    @JsonSubTypes({
            @JsonSubTypes.Type(value = AquariumData.class, name = "AQUARIUM"),
            @JsonSubTypes.Type(value = PlaygroundData.class, name = "PLAYGROUND"),
            @JsonSubTypes.Type(value = ZooData.class, name = "ZOO")
    })
    private ParkData parkData;

    public Park() {}
    public Park(final String name,
                final ParkType parkType,
                final ParkData parkData) {
        this.name = name;
        this.parkType = parkType;
        this.parkData = parkData;
    }

    public String getName() { return name; }
    public ParkType getParkType() { return parkType; }
    public ParkData getParkData() { return parkData; }
}
