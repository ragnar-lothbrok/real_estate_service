package com.assignment.realestate.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserLoginDto {

    private String userName;
    private String password;

}
