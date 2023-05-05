package com.assignment.realestate.entity.estates;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter @Setter
@Accessors(chain = true)
@Embeddable
public class Amenities {

    @Column(nullable = false, length = 50)
    @Schema(description = "Amenity Name", example = "POLICE_STATION")
    @Enumerated(EnumType.STRING)
    private AmenityName amenityName;
}
