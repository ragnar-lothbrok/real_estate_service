
package com.assignment.realestate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class UserActivityDto {

    private List<Integer> apartmentIds;

    private List<Integer> userIds;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Schema(description = "Date of buying", example = "2021-01-01")
    private LocalDate date;

    private String userAction;

    @Schema(description = "Rent Per Month", example = "12000")
    private Integer rentPerMonth;

    @Schema(description = "Security Deposit", example = "1")
    private Integer securityDeposit;
}
