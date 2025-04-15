package com.C2KProyect.Api_Rest_C2K.services;

import com.C2KProyect.Api_Rest_C2K.models.Inspection;
import com.C2KProyect.Api_Rest_C2K.repositories.IInspectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class InspectionService {
    //Implements Repositories
    @Autowired
    IInspectionRepository repository;
    // -Methods-

    //Save
    public Inspection createInspection(Inspection inspectionData) throws Exception {
        try{
            return this.repository.save(inspectionData);
        }
        catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Find all

    public List<Inspection> findAll(Inspection inspectionData) throws Exception{
        try{
            return this.repository.findAll();
        }
        catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Find by id


    public Inspection FindAll(Integer id) throws Exception{
        try{
            Optional<Inspection> inspectionSearched=this.repository.findById(id);
            if (inspectionSearched.isPresent()){
                return (Inspection) inspectionSearched.get();}
            else{
                throw new Exception("La Inspección no se encuentra en la base de datos");
            }
        }
        catch (Exception error){
            throw new Exception(error.getMessage());

        }
    }

    //Update by Id -->
    public Inspection updateById(Integer id, Inspection inspectionData) throws Exception {
        try {
            Optional<Inspection> inspectionSearched = this.repository.findById(id);
            if (inspectionSearched.isPresent()) {
                inspectionSearched.get().setLogistic_operator(inspectionData.getLogistic_operator());
                inspectionData.setVehicle(inspectionData.getVehicle());
                inspectionSearched.get().setVehicle(inspectionData.getVehicle());
                return this.repository.save(inspectionSearched.get());
            } else {
                throw new Exception("La Inspección no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    //Delete by Id -->
    public boolean deleteInspection(Integer id)throws Exception{
        try {
            Optional<Inspection> inspectionSearched=this.repository.findById(id);
            if (inspectionSearched.isPresent()){
                this.repository.delete(inspectionSearched.get());
                return true;
            }else{
                throw new Exception("La Inspección no se encuentra en la base de datos");
            }
        }
        catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }





}
