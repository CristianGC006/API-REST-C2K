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
    private Integer inspectionId;
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



    public Inspection() {
    }



    public Inspection(Integer inspectionId, Integer rentalId, InspectionEnum type) {
        this.inspectionId = inspectionId;
        this.type = type;
    }

    public Integer getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(Integer inspectionId) {
        this.inspectionId = inspectionId;
    }

    public InspectionEnum getType() {
        return type;
    }

    public void setType(InspectionEnum type) {
        this.type = type;
    }
}
