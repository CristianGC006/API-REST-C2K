package com.C2KProyect.Api_Rest_C2K.models;

import com.C2KProyect.Api_Rest_C2K.helpers.enums.ServicesEnumLogOperator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "logistic_operator")
public class LogisticOperator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idLogisticOperator;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "service_area")
    private ServicesEnumLogOperator serviceArea;

    public LogisticOperator() {

    }

    public LogisticOperator(Integer idLogisticOperator, String name, String email, String password, String phone, String address, ServicesEnumLogOperator serviceArea) {
        this.idLogisticOperator = idLogisticOperator;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.serviceArea = serviceArea;
    }

    public Integer getIdLogisticOperator() {
        return idLogisticOperator;
    }

    public void setIdLogisticOperator(Integer idLogisticOperator) {
        this.idLogisticOperator = idLogisticOperator;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ServicesEnumLogOperator getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(ServicesEnumLogOperator serviceArea) {
        this.serviceArea = serviceArea;
    }

    //Foreign key
    @OneToMany(mappedBy = "logistic_operator")
    @JsonManagedReference(value = "logistic_operator")
    private List<Inspection> inspections;








}
