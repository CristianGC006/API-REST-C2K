package com.C2KProyect.Api_Rest_C2K.services;

import com.C2KProyect.Api_Rest_C2K.models.Branch;
import com.C2KProyect.Api_Rest_C2K.repositories.IBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService {

    //Implements Repositories
    @Autowired
    IBranchRepository repository;

    //--Methods--

    //Save-->
    public Branch createBranch(Branch branchData)throws Exception{
        try{
            return this.repository.save(branchData);
        }
        catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Find all -->
    public List<Branch> findAll()throws Exception{
        try{
            return this.repository.findAll();
        } catch (Exception error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    //Find by id -->
    public Branch findById(Integer id)throws Exception{
        try{
            Optional<Branch> branchSearched=this.repository.findById(id);
            if (branchSearched.isPresent()){
                return(Branch) branchSearched.get();
            }else{
                throw new Exception("La sucursal no se encuentra en la base de datos");
            }
        }
        catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Update by Id -->
    public Branch updateById(Integer id, Branch branchData)throws Exception{
        try {
            Optional<Branch>branchSearched=this.repository.findById(id);
            if (branchSearched.isPresent()){
                branchSearched.get().setName(branchData.getName());
                branchSearched.get().setAddress(branchData.getAddress());
                branchSearched.get().setPhone(branchData.getPhone());
                branchSearched.get().setAddress(branchData.getAddress());
                branchSearched.get().setSchedule(branchData.getSchedule());
            }else{
                throw new Exception("La sucursal que quieres modificar no se encuentra en la base de datos");
            }
            return this.repository.save(branchSearched.get());
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Delete by Id -->
    public boolean deleteBranch(Integer id)throws Exception{
        try {
            Optional<Branch>branchSearched=this.repository.findById(id);
            if (branchSearched.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else{
                throw new Exception("La sucursal que quieres eliminar no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
