package com.C2KProyect.Api_Rest_C2K.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_branch")
    private Integer idBranch;
    @Column(name = "branch_name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "schedule")
    private String schedule;
    @Column(name = "status")
    private String status;

    //Foreign key
    @OneToMany(mappedBy = "branch")
   // @JsonManagedReference
    private List<Assessor> assessors;

    @OneToMany(mappedBy = "branch")
    //@JsonManagedReference
    private List<Rental> rentals;

    public Branch() {
    }

    public Branch(Integer idBranch, String name, String address, String phone, String schedule, String status) {
        this.idBranch = idBranch;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.schedule = schedule;
        this.status = status;
    }

    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

