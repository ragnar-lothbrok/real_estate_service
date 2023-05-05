package com.assignment.realestate.entity.estates;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Accessors(chain = true)
@Table(name = "user_visit_apartment")
@Entity
public class UserVisitApartment {

    @Column
    @Schema(description = "Interested in Apartment", example = "true")
    private Boolean interested;

    @EmbeddedId
    private UserVisitApartmentId userVisitApartmentId;

}
