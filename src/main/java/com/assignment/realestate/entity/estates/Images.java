package com.assignment.realestate.entity.estates;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter @Setter
@Accessors(chain = true)
@Embeddable
public class Images {

    @Column(nullable = false, length = 250)
    @Schema(description = "Image Url", example = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png")
    private String imageUrl;

    @Column(nullable = false, length = 250)
    @Schema(description = "Image Name", example = "Google Logo")
    private String imageName;
}
