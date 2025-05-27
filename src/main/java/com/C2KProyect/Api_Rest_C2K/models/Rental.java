package com.C2KProyect.Api_Rest_C2K.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

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

    //Foreign key
    @ManyToOne
    @JoinColumn(name = "id_vehicle", referencedColumnName = "vehicle_id")
    @JsonBackReference(value = "vehicle-rental")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    @JsonBackReference(value = "customer-rental")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_assessor", referencedColumnName = "id")
    @JsonBackReference(value = "rental-assessor")
    private Assessor assessor;

    @OneToMany(mappedBy = "rental")
    @JsonManagedReference(value = "rental-inspection")
    private List<Inspection> inspections;

    @ManyToOne
    @JoinColumn(name = "id_branch", referencedColumnName = "id_branch")
    @JsonBackReference(value = "rental-branch")
    private Branch branch;

    @OneToOne(mappedBy = "rental")
    @JsonManagedReference(value = "rental")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "id_admin", referencedColumnName = "id")
    @JsonBackReference(value = "admin-rental")
    private Admin admin;



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
