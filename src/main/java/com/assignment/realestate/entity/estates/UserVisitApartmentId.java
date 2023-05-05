package com.assignment.realestate.entity.estates;

import com.assignment.realestate.entity.user.RealEstateUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Accessors(chain = true)
@Embeddable
public class UserVisitApartmentId implements Serializable {

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    private RealEstateUser realEstateUser;

    @ManyToOne
    @JoinColumn(name="apartment_id")
    @JsonBackReference
    private Apartment apartment;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Column
    @Schema(description = "Date of Visit", example = "2021-01-01")
    private LocalDate visitedDate;

}
