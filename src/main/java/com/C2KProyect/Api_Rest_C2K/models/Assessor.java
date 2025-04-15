package com.C2KProyect.Api_Rest_C2K.models;

import com.C2KProyect.Api_Rest_C2K.helpers.enums.UserEnum;
import jakarta.persistence.*;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Entity
@Table(name = "assessor")
public class Assessor extends User {

    public Assessor() {
    }

    public Assessor(Integer idUser, String name, String email, String password, UserEnum userType, String phone, String address, Branch branch, List<Rental> rentals) {
        super(idUser, name, email, password, userType, phone, address);
        this.branch = branch;
        this.rentals = rentals;
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

    //Foreign key
    @ManyToOne
    @JoinColumn(name = "id_branch", referencedColumnName = "id_branch")
    private Branch branch;

    @OneToMany(mappedBy = "assessor")
    //@JsonBackReference
    private List<Rental>rentals;


}
