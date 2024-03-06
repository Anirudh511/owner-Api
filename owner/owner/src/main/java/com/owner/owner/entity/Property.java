package com.owner.owner.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property implements Serializable {

    private static final long serialVersionUID = 1776174655321501008L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String propertyName;
    private String title;
    private Double price;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_id", nullable = false, referencedColumnName = "id")
    private List<PropertyImages> img;

}
