package com.C2KProyect.Api_Rest_C2K.models;

import jakarta.persistence.*;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Entity
@Table(name = "assessor")
public class Assessor extends User {

    public Assessor() {
    }
    //Foreign key
    @ManyToOne
    @JoinColumn(name = "id_branch", referencedColumnName = "id_branch")
    private Branch branch;

    @OneToMany(mappedBy = "assessor")
    //@JsonBackReference
    private List<Rental>rentals;


}
