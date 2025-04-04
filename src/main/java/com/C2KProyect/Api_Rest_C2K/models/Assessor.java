package com.C2KProyect.Api_Rest_C2K.models;

import jakarta.persistence.*;

@Entity
@Table(name = "assessor")
public class Assessor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessor_id")
    private Integer assessorId;

    @Column(name = "name")
    private String name;


    @Column(name = "phone")
    private String phone;

    public Assessor() {
    }

    public Assessor(Integer assessorId, String name, Integer branchId, String phone) {
        this.assessorId = assessorId;
        this.name = name;
        this.phone = phone;
    }

    public Integer getAssessorId() {
        return assessorId;
    }

    public void setAssessorId(Integer assessorId) {
        this.assessorId = assessorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
