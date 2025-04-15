package com.C2KProyect.Api_Rest_C2K.models;

import com.C2KProyect.Api_Rest_C2K.helpers.enums.InspectionEnum;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@Entity
@Table(name = "inspections")
public class Inspection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inspection")
    private Integer id;
    @Column(name = "type")
    private InspectionEnum type;
    //Aca va la foto

    //Foreign key
    @ManyToOne
    @JoinColumn(name = "id_branch", referencedColumnName = "id_branch")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "id_rental", referencedColumnName = "id_rental")
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "id_vehicle", referencedColumnName = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name="logistic_operator", referencedColumnName= "id_user")
    private LogisticOperator logistic_operator;


    public Inspection() {
    }


    public Inspection(Integer id, InspectionEnum type, Branch branch, Rental rental, Vehicle vehicle) {
        this.id = id;
        this.type = type;
        this.branch = branch;
        this.rental = rental;
        this.vehicle = vehicle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InspectionEnum getType() {
        return type;
    }

    public void setType(InspectionEnum type) {
        this.type = type;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LogisticOperator getLogistic_operator() {
        return logistic_operator;
    }

    public void setLogistic_operator(LogisticOperator logistic_operator) {
        this.logistic_operator = logistic_operator;
    }
}
