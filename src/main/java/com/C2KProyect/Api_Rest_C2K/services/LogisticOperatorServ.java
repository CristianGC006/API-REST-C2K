package com.C2KProyect.Api_Rest_C2K.services;

import com.C2KProyect.Api_Rest_C2K.models.LogisticOperator;
import com.C2KProyect.Api_Rest_C2K.repositories.ILogisticOperatorRepository;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class LogisticOperatorServ {

    @Autowired
    ILogisticOperatorRepository repository;
    // -Methods-

    //Save
    public LogisticOperator createLogisticOperator(LogisticOperator logisticOperatorData) throws Exception {
        try{
            return this.repository.save(logisticOperatorData);
        }
        catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Find all
    public List<LogisticOperator> findAll() throws Exception {
        try{
            return this.repository.findAll();
        }
        catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Find by id
    public LogisticOperator findByID(Integer id) throws Exception {
        try {
            return this.repository.findById(id).orElseThrow(() -> new Exception("El operador logístico no se encuentra en la base de datos"));
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    //Update by Id -->

    public LogisticOperator updateById(Integer id, LogisticOperator logisticOperatorData) throws Exception {
        try {
            LogisticOperator logisticOperatorSearched = this.findByID(id);
            if (logisticOperatorSearched != null) {
                logisticOperatorSearched.setName(logisticOperatorData.getName());
                logisticOperatorSearched.setAddress(logisticOperatorData.getAddress());
                logisticOperatorSearched.setPhone(logisticOperatorData.getPhone());
                logisticOperatorSearched.setEmail(logisticOperatorData.getEmail());
                logisticOperatorSearched.setServiceArea(logisticOperatorData.getServiceArea());
                logisticOperatorSearched.setLogisticOperatorCode(logisticOperatorData.getLogisticOperatorCode());
                if (logisticOperatorData.getPassword() != null && !logisticOperatorData.getPassword().trim().isEmpty()) {
                    logisticOperatorSearched.setPassword(logisticOperatorData.getPassword());
                }
                return this.repository.save(logisticOperatorSearched);
            } else {
                throw new Exception("El operador logístico no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Delete by Id -->
    public boolean deleteById(Integer id) throws Exception {
        try {
            LogisticOperator logisticOperatorSearched = this.findByID(id);
            if (logisticOperatorSearched != null) {
                this.repository.delete(logisticOperatorSearched);
                return true;
            } else {
                throw new Exception("El operador logístico no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


}
