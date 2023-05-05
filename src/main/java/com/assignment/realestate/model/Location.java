package com.assignment.realestate.model;

import com.assignment.realestate.entity.location.City;
import com.assignment.realestate.entity.location.Country;
import com.assignment.realestate.entity.location.State;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Location {

    @Schema(description = "Location Id", example = "1")
    private String id;
    @Schema(description = "Location Name", example = "Istanbul")
    private String area;
    @Schema(description = "Location Latitude", example = "41.01384")
    private City city;
    @Schema(description = "Location Longitude", example = "28.94966")
    private List<State> states;
    @Schema(description = "Location Country")
    private Country country;

}
