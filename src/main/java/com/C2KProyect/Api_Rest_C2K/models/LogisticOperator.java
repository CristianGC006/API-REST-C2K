package com.C2KProyect.Api_Rest_C2K.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GeneratedColumn;

@Entity
@Table(name = "logistic_operator")
public class LogisticOperator extends User {



    @Column(name = "certifications")
    private String certifications ;




    public LogisticOperator() {
    }
    public LogisticOperator(Integer idLogisticOperator, String name, String certifications) {

        this.certifications = certifications;
    }


    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }


}
