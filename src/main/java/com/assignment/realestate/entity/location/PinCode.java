package com.assignment.realestate.entity.location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter @Setter
@Accessors(chain = true)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"country_id", "pin"}, name = "uk_pin_code_country_id_pin"))
@Entity
public class PinCode {

    @Id
    @Column(length = 15)
    @Schema(description = "Pin Code Id", example = "1")
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false, foreignKey = @ForeignKey(name = "fk_pin_code_country_id"))
    @Schema(description = "Country")
    private Country country;

    @Column(nullable = false, length = 10)
    @Schema(description = "Pin Code", example = "34000")
    private String pin;

    @Column(nullable = false, length = 120)
    private String areaName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false, foreignKey = @ForeignKey(name = "fk_pin_code_city_id"))
    private City city;

}
