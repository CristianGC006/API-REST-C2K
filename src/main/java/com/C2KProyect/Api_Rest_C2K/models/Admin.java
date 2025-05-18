package com.C2KProyect.Api_Rest_C2K.models;

import com.C2KProyect.Api_Rest_C2K.helpers.enums.UserEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;


@Entity
@Table(name="admin")
public class Admin extends User {
    public Admin() {
    }
    public Admin(Integer idUser, String name, String email, String password, UserEnum userType, String phone, String address, List<Branch> branches, List<Assessor> assessors, List<Rental> rentals, List<Vehicle> vehicles) {
        super(idUser, name, email, password, userType, phone, address);
        this.branches = branches;
        this.assessors = assessors;
        this.rentals = rentals;
        this.vehicles = vehicles;
    }

    //Foreign key

    @OneToMany(mappedBy = "admin")
    @JsonManagedReference(value = "admin-branch")
    private List<Branch> branches;

    @OneToMany(mappedBy = "admin")
    @JsonManagedReference(value = "admin-assessor")
    private List<Assessor> assessors;

    @OneToMany(mappedBy = "admin")
    @JsonManagedReference(value = "admin-rental")
    private List<Rental> rentals;

    @OneToMany(mappedBy = "admin")
    @JsonManagedReference(value = "admin-vehicle")
    private List<Vehicle> vehicles;

    // Getters y Setters

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public List<Assessor> getAssessors() {
        return assessors;
    }

    public void setAssessors(List<Assessor> assessors) {
        this.assessors = assessors;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }


}
