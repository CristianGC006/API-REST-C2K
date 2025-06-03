package com.C2KProyect.Api_Rest_C2K.models;

import com.C2KProyect.Api_Rest_C2K.helpers.enums.IdentificationType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name="admin")
public class Admin{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdmin;
    @Column(name = "name")
    private String name;
    @Column(name = "documentType")
    private IdentificationType identificationType;
    @Column(name = "documentNumber")
    private String documentNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "password")
    private String password;
    @Column(name = "adminCode")
    private String adminCode;

    public Admin() {
    }

    public Admin( String adminCode, String password, String email,String phone, String name, Integer idAdmin) {
        this.adminCode = adminCode;
        this.password = password;
        this.email = email;
        this.phone= phone;
        this.name = name;
        this.idAdmin = idAdmin;
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

    @OneToMany(mappedBy = "admin")
    @JsonManagedReference(value = "admin-customer")
    private List<Customer> customers;

    // Getters y Setters
    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
