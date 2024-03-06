package com.owner.owner.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto {
    private Long id;
    private String propertyName;
    private String title;
    private Double price;
    private String description;

    private List<PropertyImagesDto> img;


}
