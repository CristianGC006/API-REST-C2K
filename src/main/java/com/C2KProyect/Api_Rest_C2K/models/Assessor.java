package com.C2KProyect.Api_Rest_C2K.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "assessor")
public class Assessor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idAssessor;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    protected String email;
    @Column(name = "password")
    protected String password;
    @Column(name="assessorCode")
    private String assessorCode;
    @Column(name = "phone")
    protected String phone;
    @Column(name = "address")
    private String address;

    public Assessor() {
    }

    public Assessor(Integer idAssessor, String name, String email,String assessorCode, String password, String phone, String address) {
        this.idAssessor = idAssessor;
        this.name = name;
        this.email = email;
        this.password = password;
        this.assessorCode = assessorCode;
        this.phone = phone;
        this.address = address;
    }

    public Integer getIdAssessor() {
        return idAssessor;
    }

    public void setIdAssessor(Integer idAssessor) {
        this.idAssessor = idAssessor;
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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getAssessorCode() {
        return assessorCode;
    }

    public void setAssessorCode(String assessorCode) {
        this.assessorCode = assessorCode;
    }

    //Foreign key
    @ManyToOne
    @JoinColumn(name = "id_branch", referencedColumnName = "id_branch")
    @JsonBackReference(value = "assessor-branch")
    private Branch branch;

    @OneToMany(mappedBy = "assessor")
    @JsonManagedReference(value = "rental-assessor")
    private List<Rental>rentals;

    @ManyToOne
    @JoinColumn(name = "id_admin", referencedColumnName = "id")
    @JsonBackReference(value = "admin-assessor")
    private Admin admin;


}
