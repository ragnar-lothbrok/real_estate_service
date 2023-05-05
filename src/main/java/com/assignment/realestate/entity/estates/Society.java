package com.assignment.realestate.entity.estates;

import com.assignment.realestate.entity.location.PinCode;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter @Setter
@Table(name = "society", indexes = {
        @Index(name = "society_society_name_index", columnList = "society_name"),
        @Index(name = "society_pin_code_id_index", columnList = "pin_code_id")
})
@Entity
public class Society {

    @Id
    @Column
    @Schema(description = "Society Id", example = "1")
    @SequenceGenerator(name = "society_id_generator", sequenceName = "society_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "society_id_generator")
    private Integer societyId;

    @Column(name="society_name", nullable = false, length = 50)
    @Schema(description = "Society Name", example = "Society 1")
    private String societyName;

    @Column(nullable = false, length = 100)
    @Schema(description = "Number of Buildings", example = "90")
    private Short numberOfBuildings;

    @Column(nullable = false, length = 100)
    @Schema(description = "Latitude", example = "12.123456")
    private Float latitude;

    @Column(nullable = false, length = 100)
    @Schema(description = "Longitude", example = "77.123456")
    private Float longitude;

    @Column(nullable = false, length = 100)
    @Schema(description = "Address Line 1", example = "Address Line 1")
    private String addressLine1;

    @Column(length = 100)
    @Schema(description = "Address Line 2", example = "Address Line 2")
    private String addressLine2;

    @ManyToOne
    @JoinColumn(name = "pin_code_id", nullable = false, foreignKey = @ForeignKey(name = "fk_society_centre_pin_code_id"))
    private PinCode pinCode;

    @ElementCollection
    @CollectionTable(name = "society_amenities", joinColumns = @JoinColumn(name = "society_id", foreignKey = @ForeignKey(name = "fk_society_amenity_id")))
    private List<Amenities> amenities;

    @JsonManagedReference
    @OneToMany(mappedBy = "society", cascade = CascadeType.ALL)
    private Set<Building> buildings;

}
