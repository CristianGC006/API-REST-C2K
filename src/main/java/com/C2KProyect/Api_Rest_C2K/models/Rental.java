package com.C2KProyect.Api_Rest_C2K.models;

import jakarta.persistence.*;

@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rental")
    private Integer idRental;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;

    public Rental() {
    }
    public Rental(Integer idRental, String name, String description, Double price) {
        this.idRental = idRental;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Integer getIdRental() {
        return idRental;
    }

    public void setIdRental(Integer idRental) {
        this.idRental = idRental;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
