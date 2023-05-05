package com.assignment.realestate.entity.user;

import com.assignment.realestate.dto.UserBuysDto;
import com.assignment.realestate.dto.UserOwnsDto;
import com.assignment.realestate.dto.UserRentsDto;
import com.assignment.realestate.dto.UserVisitsDto;
import com.assignment.realestate.entity.estates.UserBuysApartment;
import com.assignment.realestate.entity.estates.UserOwnsApartment;
import com.assignment.realestate.entity.estates.UserRentsApartment;
import com.assignment.realestate.entity.estates.UserVisitApartment;
import com.assignment.realestate.entity.location.PinCode;
import com.assignment.realestate.utils.MapperUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter
@Accessors(chain = true)
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "real_estate_user", uniqueConstraints = @UniqueConstraint(columnNames = "email_id", name = "uk_real_estate_user_email_id"),
        indexes = {
                @Index(name = "real_estate_user_phone_number_index", columnList = "phone_number"),
                @Index(name = "real_estate_user_pin_code_id_index", columnList = "pin_code_id")
        })
@Entity
public class RealEstateUser {

    @Id
    @Column
    @Schema(description = "User Id", example = "1")
    @SequenceGenerator(name = "real_estate_user_id_seq", sequenceName = "real_estate_user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "real_estate_user_id_seq")
    private Integer userId;

    @Column(nullable = false, name = "email_id")
    @Schema(description = "Email Id", example = "xyz@gmail.com")
    private String emailId;

    @Column(name = "phone_number", nullable = false, length = 12)
    @Schema(description = "Phone Number", example = "1234567890")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Title title;

    @Column(nullable = false, length = 30)
    @Schema(description = "First Name", example = "John")
    private String firstName;

    @Column(length = 30)
    @Schema(description = "Middle Name", example = "Doe")
    private String middleName;

    @Column(length = 30)
    @Schema(description = "Last Name", example = "Doe")
    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Column
    @Schema(description = "Date of Birth", example = "2021-01-01")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Gender gender;

    @Column(nullable = false, length = 100)
    @Schema(description = "Address Line 1", example = "123, ABC Street")
    private String addressLine1;

    @Column(length = 100)
    @Schema(description = "Address Line 2", example = "Near XYZ Mall")
    private String addressLine2;

    @ManyToOne
    @JoinColumn(name = "pin_code_id", nullable = false, foreignKey = @ForeignKey(name = "fk_real_estate_user_pin_code_id"))
    @Schema(description = "Pin Code", example = "123456")
    private PinCode pinCode;

    @JsonIgnore
    @OneToMany(mappedBy = "userVisitApartmentId.realEstateUser")
    @Schema(description = "User Visited Apartments")
    private Set<UserVisitApartment> userVisitApartments;

    @JsonIgnore
    @OneToMany(mappedBy = "userApartmentId.realEstateUser")
    @Schema(description = "User Owns Apartments")
    private Set<UserOwnsApartment> userOwnsApartments;

    @JsonIgnore
    @OneToMany(mappedBy = "userRentsApartmentId.realEstateUser")
    @Schema(description = "User Rents Apartments")
    private Set<UserRentsApartment> userRentsApartments;

    @JsonIgnore
    @OneToMany(mappedBy = "userBuysApartmentId.realEstateUser")
    @Schema(description = "User Buys Apartments")
    private Set<UserBuysApartment> userBuysApartments;

    @Transient
    private Set<UserBuysDto> userBuysDtos = new HashSet<>();

    @Transient
    private Set<UserRentsDto> userRentDtos = new HashSet<>();

    @Transient
    private Set<UserOwnsDto> userOwnsDtos = new HashSet<>();

    @Transient
    private Set<UserVisitsDto> userVisitsDtos = new HashSet<>();
}
