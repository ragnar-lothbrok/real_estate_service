package com.assignment.realestate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class UserOwnsDto {

    @Schema(description = "Apartment Id", example = "1")
    private Integer apartmentId;

    @Schema(description = "User Id", example = "1")
    private Integer userId;
}
