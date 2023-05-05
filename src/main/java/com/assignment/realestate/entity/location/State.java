package com.assignment.realestate.entity.location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter @Setter
@Entity
@Accessors(chain = true)
public class State {

    @Id
    @Column
    @Schema(description = "State Id", example = "1")
    private Integer id;

    @Column(nullable = false, length = 90)
    @Schema(description = "State Name", example = "Istanbul")
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false, foreignKey = @ForeignKey(name = "fk_state_country_id"))
    @Schema(description = "Country")
    private Country country;

}
