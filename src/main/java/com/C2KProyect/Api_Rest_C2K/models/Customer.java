package com.C2KProyect.Api_Rest_C2K.models;

import com.C2KProyect.Api_Rest_C2K.helpers.enums.GenderType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idCustomer;
    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String  lastName;
    @Column(name="identificationType")
    private String identificationType;
    @Column(name = "identificationNumber")
    private String identificationNumber;
    @Column(name = "genderType")
    private GenderType genderType;
    @Column(name="nationality")
    private String nationality;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "license")
    private String license;
    @Column(name = "password")
    private String password;
    @Column(name = "record_date")
    private Date recordDate;


    //Foreign key
    @OneToMany(mappedBy = "customer")
    @JsonBackReference(value = "customer-rental")
    private List<Rental> rentals;

    @OneToMany(mappedBy = "customers")
    @JsonBackReference(value = "customer-vehicle")
    private List<Vehicle> vehicles;

    @ManyToOne
    @JoinColumn(name = "id_admin", referencedColumnName = "id")
    @JsonBackReference(value = "admin-customer")
    private Admin admin;


    public Customer() {
    }

    public Customer(Integer idCustomer, String name, String lastName, String identificationType, String identificationNumber, GenderType genderType, String nationality, String email, String phone, String license, String password, Date recordDate) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.lastName = lastName;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.genderType = genderType;
        this.nationality = nationality;
        this.email = email;
        this.phone = phone;
        this.license = license;
        this.password = password;
        this.recordDate = recordDate;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setLicense(String license) {
        this.license = license;
    }
    public String getLicense() {
        return license;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
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

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
