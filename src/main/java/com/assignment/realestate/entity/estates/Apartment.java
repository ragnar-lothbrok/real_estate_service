package com.assignment.realestate.entity.estates;

import com.assignment.realestate.dto.UserBuysDto;
import com.assignment.realestate.dto.UserOwnsDto;
import com.assignment.realestate.dto.UserRentsDto;
import com.assignment.realestate.dto.UserVisitsDto;
import com.assignment.realestate.entity.location.PinCode;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter
@Accessors(chain = true)
@Table(name = "apartment", indexes = {
        @Index(name = "apartment_listing_type_index", columnList = "listing_type"),
        @Index(name = "apartment_property_type_index", columnList = "property_type"),
        @Index(name = "apartment_selling_price_index", columnList = "selling_price"),
        @Index(name = "apartment_number_of_rooms_index", columnList = "number_of_rooms"),
        @Index(name = "apartment_available_index", columnList = "available"),
        @Index(name = "apartment_pin_code_id_index", columnList = "pin_code_id")
})
@Entity
public class Apartment {

    @Id
    @Column
    @SequenceGenerator(name = "apartment_id_generator", sequenceName = "apartment_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartment_id_generator")
    @Schema(description = "Apartment Id", example = "1")
    private Integer apartmentId;

    @Column(nullable = false, length = 50)
    @Schema(description = "Apartment Name", example = "Apartment 1")
    private String apartmentName;

    @Column(nullable = false, length = 5)
    @Schema(description = "Floor Number", example = "1")
    private Short floorNumber;

    @Column(name = "listing_type", nullable = false, length = 100)
    @Schema(description = "Listing Type", example = "SELL")
    @Enumerated(EnumType.STRING)
    private ListingType listingType;

    @Column(name = "property_type", nullable = false, length = 100)
    @Schema(description = "Property Type", example = "ROW_HOUSE")
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @Column(length = 100)
    @Schema(description = "Property Sub Type", example = "ROW_HOUSE")
    private Double areaInSquareFeet;

    @Column(name = "number_of_rooms", length = 5)
    @Schema(description = "Number of Rooms", example = "1")
    private Short numberOfRooms;

    @Column(name = "selling_price", length = 100)
    @Schema(description = "Selling Price", example = "1100000")
    private Double sellingPrice;

    @Column(length = 100)
    @Schema(description = "Security Deposit", example = "1100000")
    private Double securityDeposit;

    @Column
    @Schema(description = "Property Age in Years", example = "20")
    private Integer propertyAgeInYears;

    @Column(length = 100)
    @Schema(description = "Rent Per Month", example = "11000")
    private Double rentPerMonth;

    @Column(name = "available", nullable = false)
    @Schema(description = "Available", example = "true")
    private boolean available;

    @Column
    @Schema(description = "Pets Allowed", example = "true")
    private boolean petsAllowed;

    @Column
    @Schema(description = "balcony", example = "true")
    private boolean balcony;

    @Column
    @Schema(description = "terrace", example = "true")
    private boolean terrace;

    @Column
    @Schema(description = "garden", example = "true")
    private boolean garden;

    @Column
    @Schema(description = "elevator", example = "true")
    private boolean elevator;

    @Column
    @Schema(description = "parking", example = "true")
    private boolean parking;

    @Column
    @Schema(description = "Fully Furnished", example = "false")
    private boolean fullFurnished;

    @Column
    @Schema(description = "Total Floors", example = "3")
    private int totalFloors;

    @Column(nullable = false, length = 100)
    @Schema(description = "Latitude", example = "12.9716")
    private Float latitude;

    @Column(nullable = false, length = 100)
    @Schema(description = "Longitude", example = "77.5946")
    private Float longitude;

    @Column(nullable = false, length = 100)
    @Schema(description = "Address Line 1", example = "Address Line 1")
    private String addressLine1;

    @Column(length = 100)
    @Schema(description = "Address Line 2", example = "Address Line 2")
    private String addressLine2;

    @ManyToOne
    @JoinColumn(name = "pin_code_id", nullable = false, foreignKey = @ForeignKey(name = "fk_apartment_centre_pin_code_id"))
    @Schema(description = "Pin Code")
    private PinCode pinCode;

    @ElementCollection
    @CollectionTable(name = "apartment_amenities", joinColumns = @JoinColumn(name = "apartment_id", foreignKey = @ForeignKey(name = "fk_apartment_amenities_id")))
    @Schema(description = "Amenities")
    private List<Amenities> amenities;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building_id", foreignKey = @ForeignKey(name = "fk_apartment_building_id"))
    private Building building;

    @ElementCollection
    @CollectionTable(name = "apartment_images", joinColumns = @JoinColumn(name = "apartment_id", foreignKey = @ForeignKey(name = "fk_apartment_images_id")))
    private List<Images> images;

    @JsonIgnore
    @OneToMany(mappedBy = "userVisitApartmentId.apartment")
    private Set<UserVisitApartment> userVisitApartments;

    @JsonIgnore
    @OneToMany(mappedBy = "userApartmentId.apartment")
    @Column(nullable = false)
    private Set<UserOwnsApartment> userOwnsApartments;

    @JsonIgnore
    @OneToMany(mappedBy = "userRentsApartmentId.apartment")
    private Set<UserRentsApartment> userRentsApartments;

    @JsonIgnore
    @OneToMany(mappedBy = "userBuysApartmentId.apartment")
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
