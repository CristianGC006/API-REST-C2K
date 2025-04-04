package com.C2KProyect.Api_Rest_C2K.models;

import com.C2KProyect.Api_Rest_C2K.helpers.enums.UserEnum;
import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.security.PrivateKey;

@Enabled
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id_user")
    private Integer idUser;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="user_type")
    private UserEnum userType;

    public User() {
    }

    public User(Integer idUser, String email, String password, UserEnum userType) {
        this.idUser = idUser;
        this.email = email;
        this.password = password;
        this.userType = userType;
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
}
