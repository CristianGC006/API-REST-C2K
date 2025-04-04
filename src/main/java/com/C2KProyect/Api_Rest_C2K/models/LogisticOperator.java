package com.C2KProyect.Api_Rest_C2K.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GeneratedColumn;

@Entity
@Table(name = "logistic_operator")
public class LogisticOperator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_logistic_costumer")
    private Integer idLogisticOperator;
    @Column(name = "name")
    private String name;
    @Column(name = "certifications")
    private String certifications ;


    public LogisticOperator() {
    }
    public LogisticOperator(Integer idLogisticOperator, String name, String certifications) {
        this.idLogisticOperator = idLogisticOperator;
        this.name = name;
        this.certifications = certifications;
    }

    public Integer getIdLogisticOperator() {
        return idLogisticOperator;
    }

    public void setIdLogisticOperator(Integer idLogisticOperator) {
        this.idLogisticOperator = idLogisticOperator;
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
