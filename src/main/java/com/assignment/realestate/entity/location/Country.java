package com.assignment.realestate.entity.location;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@Accessors(chain = true)
@Entity
public class Country {

    @Id
    @Column
    @Schema(description = "Country Id", example = "1")
    private Integer id;

    @Column(nullable = false, length = 60)
    @Schema(description = "Country Name", example = "Turkey")
    private String name;

}
