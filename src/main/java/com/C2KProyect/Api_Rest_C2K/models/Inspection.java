package com.C2KProyect.Api_Rest_C2K.models;

import com.C2KProyect.Api_Rest_C2K.helpers.enums.InspectionEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "inspections")
public class Inspection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inspection_id")
    private Integer inspectionId;
    @Column(name = "type")
    private InspectionEnum type;
    //Aca va la foto


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
