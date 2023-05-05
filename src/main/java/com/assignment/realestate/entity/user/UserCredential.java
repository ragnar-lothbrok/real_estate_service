package com.assignment.realestate.entity.user;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
@Table(name = "user_credential")
@Entity
public class UserCredential implements Serializable {

    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;


    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @OneToOne(fetch = FetchType.EAGER)
    private RealEstateUser realEstateUser;

    @Column(nullable = false)
    private String password;

}
