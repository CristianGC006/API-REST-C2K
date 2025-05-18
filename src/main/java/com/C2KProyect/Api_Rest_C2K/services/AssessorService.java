package com.C2KProyect.Api_Rest_C2K.services;

import com.C2KProyect.Api_Rest_C2K.models.Assessor;
import com.C2KProyect.Api_Rest_C2K.models.User;
import com.C2KProyect.Api_Rest_C2K.repositories.IAssessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessorService {

    //Save-->
    //Implements Repositories
    @Autowired
    IAssessorRepository repository;

    //--Methods--

    //Save-->
    public Assessor createAssessor(Assessor assessorData) throws Exception {
        try {
            return this.repository.save(assessorData);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

//Find all -->
    public List<Assessor> findAll()throws Exception{
        try {
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Find by id -->
    public Assessor findById(Integer id)throws Exception{
        try{
            Optional<Assessor> assessorSearched=this.repository.findById(id);
            if (assessorSearched.isPresent()){
                return(Assessor) assessorSearched.get();
            }else{
                throw new Exception("El asesor no se encuentra en la base de datos");
            }
        }
        catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Update by Id -->
    public Assessor updateById(Integer id, User assessorData)throws Exception{
        try {
            Optional<Assessor> assessorSearched =this.repository.findById(id);
            if (assessorSearched.isPresent()){
                assessorSearched.get().setName(assessorData.getName());
                assessorSearched.get().setEmail(assessorData.getEmail());
                assessorSearched.get().setPassword(assessorData.getPassword());

            }else{
                throw new Exception("El usuario que quieres modificar no se encuentra en la base de datos");
            }
            return this.repository.save(assessorSearched.get());
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Delete by Id -->
    public boolean deleteAssessor(Integer id)throws Exception{
        try {
            Optional<Assessor>assessorSearched=this.repository.findById(id);
            if (assessorSearched.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else{
                throw new Exception("El asesor que quieres eliminar no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
