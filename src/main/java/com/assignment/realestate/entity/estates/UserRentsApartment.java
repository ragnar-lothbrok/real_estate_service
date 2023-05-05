package com.assignment.realestate.entity.estates;

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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Accessors(chain = true)
@Table(name = "user_rents_apartment")
@Entity
public class UserRentsApartment {

    @EmbeddedId
    private UserRentsApartmentId userRentsApartmentId;

    @Column
    @Schema(description = "Rent Per Month", example = "12000")
    private Integer rentPerMonth;

    @Column
    @Schema(description = "Security Deposit", example = "12000")
    private Integer securityDeposit;

}
