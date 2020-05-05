package com.uncmath25.template.park.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.uncmath25.template.park.model.enums.AnimalType;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "animalType",
        defaultImpl = AnimalType.class,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dolphin.class, name = "DOLPHIN"),
        @JsonSubTypes.Type(value = Lion.class, name = "LION")
})
public abstract class Animal {
    private String name;
    private AnimalType animalType;

    public Animal() {}
    public Animal(final String name,
                  final AnimalType animalType) {
        this.animalType = animalType;
    }

    public String getName() { return name; }
    public AnimalType getAnimalType() { return animalType; }
}
