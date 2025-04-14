package com.C2KProyect.Api_Rest_C2K.models;

import com.C2KProyect.Api_Rest_C2K.helpers.enums.UserEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.security.PrivateKey;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id_user")
    private Integer idUser;
    @Column(name="email")
    protected String email;
    @Column(name="password")
    protected String password;
    @Column(name="user_type")
    private UserEnum userType;
    @Column(name = "phone")
    protected String phone;
    @Column(name = "address")
    private String address;


    public User() {
    }

    public User(Integer idUser, String email, String password, UserEnum userType, String phone, String address) {
        this.idUser = idUser;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.phone = phone;
        this.address = address;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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

    public UserEnum getUserType() {
        return userType;
    }

    public void setUserType(UserEnum userType) {
        this.userType = userType;
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
}
