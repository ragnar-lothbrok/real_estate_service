package com.assignment.realestate.entity.estates;

import com.assignment.realestate.entity.user.RealEstateUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
@Embeddable
public class UserApartmentId implements Serializable {

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    private RealEstateUser realEstateUser;

    @ManyToOne
    @JoinColumn(name="apartment_id")
    @JsonBackReference
    private Apartment apartment;

}
