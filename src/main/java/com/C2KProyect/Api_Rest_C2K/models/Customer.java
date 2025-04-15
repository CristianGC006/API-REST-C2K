package com.C2KProyect.Api_Rest_C2K.models;

import com.C2KProyect.Api_Rest_C2K.helpers.enums.UserEnum;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer extends User{

    @Column(name = "name")
    private String name;
    @Column(name = "record_date")
    private Date recordDate;

    //Foreign key
    @OneToMany(mappedBy = "customer")
    //@JsonBackReference
    private List<Rental>rentals;

    @OneToMany(mappedBy = "customers")
    //@JsonBackReference
    private List<Vehicle>vehicles;



    public Customer() {
    }

    public Customer(Integer idUser, String name, String email, String password, UserEnum userType, String phone, String address, String name1, Date recordDate, List<Rental> rentals, List<Vehicle> vehicles) {
        super(idUser, name, email, password, userType, phone, address);
        this.name = name1;
        this.recordDate = recordDate;
        this.rentals = rentals;
        this.vehicles = vehicles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }
}

