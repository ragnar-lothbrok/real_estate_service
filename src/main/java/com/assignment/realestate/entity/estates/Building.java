package com.assignment.realestate.entity.estates;

import com.assignment.realestate.entity.location.PinCode;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Accessors(chain = true)
@Table(name = "building", indexes = {
        @Index(name = "building_building_name_index", columnList = "building_name"),
        @Index(name = "building_pin_code_id_index", columnList = "pin_code_id")
})
@Entity
public class Building {

    @Id
    @Column
    @Schema(description = "Building Id", example = "1")
    @SequenceGenerator(name = "building_id_generator", sequenceName = "building_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "building_id_generator")
    private Integer buildingId;

    @Column(name = "building_name", nullable = false, length = 50)
    @Schema(description = "Building Name", example = "Building 1")
    private String buildingName;

    @Column(nullable = false, length = 5)
    @Schema(description = "Number of Floors", example = "1")
    private Short numberOfFloors;

    @Column(nullable = false, length = 100)
    @Schema(description = "Number of Apartments", example = "120")
    private Short numberOfApartments;

    @Column(nullable = false, length = 100)
    @Schema(description = "Latitude", example = "12.34343")
    private Float latitude;

    @Column(nullable = false, length = 100)
    @Schema(description = "Longitude", example = "12.34343")
    private Float longitude;

    @Column(nullable = false, length = 100)
    @Schema(description = "Address Line 1", example = "Address Line 1")
    private String addressLine1;

    @Column(length = 100)
    @Schema(description = "Address Line 2", example = "Address Line 2")
    private String addressLine2;

    @ManyToOne
    @JoinColumn(name = "pin_code_id", nullable = false, foreignKey = @ForeignKey(name = "fk_building_centre_pin_code_id"))
    private PinCode pinCode;

    @ElementCollection
    @CollectionTable(name = "building_amenities", joinColumns = @JoinColumn(name = "building_id", foreignKey = @ForeignKey(name = "fk_building_amenity_id")))
    private List<Amenities> amenities;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "society_id", foreignKey = @ForeignKey(name = "fk_building_society_id"))
    private Society society;

    @JsonManagedReference
    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    private List<Apartment> apartments;
}
