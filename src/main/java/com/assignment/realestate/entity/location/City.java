package com.assignment.realestate.entity.location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@Entity
public class City {

    @Id
    @Column
    @Schema(description = "City Id", example = "1")
    private Integer id;

    @Column(nullable = false)
    @Schema(description = "City Name", example = "Istanbul")
    private String name;

    @Column(nullable = false)
    @Schema(description = "City Latitude", example = "41.01384")
    private Double latitude;

    @Column(nullable = false)
    @Schema(description = "City Longitude", example = "28.94966")
    private Double longitude;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false, foreignKey = @ForeignKey(name = "fk_city_state_state_id"))
    private State state;

}
