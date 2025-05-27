package com.C2KProyect.Api_Rest_C2K.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Integer vehicleId;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "color")
    private String color;
    @Column(name = "plate")
    private String plate;
    @Column(name = "year")
    private Integer year;
    @Column(name = "type")
    private String type;
    @Column(name = "image_url")
    private String imageUrl;

    //Foreign key
    @OneToMany(mappedBy = "vehicle")
    @JsonManagedReference(value = "vehicle-rental")
    private List<Rental>rentals;

    @ManyToOne
    @JoinColumn(name="id_user", referencedColumnName = "id")
    @JsonBackReference(value = "customer-vehicle")
    private Customer customers;

    @ManyToOne
    @JoinColumn(name="id_branch", referencedColumnName = "id_branch")
    @JsonBackReference(value = "vehicle-branch")
    private Branch branches;

    @OneToMany(mappedBy = "vehicle")
    @JsonManagedReference(value = "vehicle-inspection")
    private List<Inspection>inspections;

    @ManyToOne
    @JoinColumn(name = "id_admin", referencedColumnName = "id")
    @JsonBackReference(value = "admin-vehicle")
    private Admin admin;





    public Vehicle() {
    }

    public Vehicle(Integer vehicleId, String brand, String model, String color, String plate, Integer year, String type, String imageUrl) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.plate = plate;
        this.year = year;
        this.type = type;
        this.imageUrl = imageUrl;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
