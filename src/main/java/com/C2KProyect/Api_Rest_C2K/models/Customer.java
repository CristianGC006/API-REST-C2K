package com.C2KProyect.Api_Rest_C2K.models;

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

    public Customer(Integer idCustomer, String name, String phone, String address, Date recordDate) {

        this.name = name;
        this.recordDate = recordDate;
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

