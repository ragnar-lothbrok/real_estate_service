package com.assignment.realestate.entity.estates;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Accessors(chain = true)
@Table(name = "user_owns_apartment")
@Entity
public class UserOwnsApartment {

    @EmbeddedId
    private UserApartmentId userApartmentId;

}
