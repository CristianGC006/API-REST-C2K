package com.C2KProyect.Api_Rest_C2K.models;

import com.C2KProyect.Api_Rest_C2K.helpers.enums.UserEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.GeneratedColumn;

import java.util.List;

@Entity
@Table(name = "logistic_operator")
public class LogisticOperator extends User {



    @Column(name = "certifications")
    private String certifications ;

    //Foreign key
    @OneToMany(mappedBy = "logistic_operator")
    @JsonManagedReference(value = "logistic_operator")

    private List<Inspection> inspections;





    public LogisticOperator() {
    }

    public LogisticOperator(Integer idUser, String name, String email, String password, UserEnum userType, String phone, String address, String certifications, List<Inspection> inspections) {
        super(idUser, name, email, password, userType, phone, address);
        this.certifications = certifications;
        this.inspections = inspections;
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }


}
