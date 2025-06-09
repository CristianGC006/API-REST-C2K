package com.C2KProyect.Api_Rest_C2K.services;

import com.C2KProyect.Api_Rest_C2K.models.Admin;
import com.C2KProyect.Api_Rest_C2K.repositories.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    IAdminRepository repository;

    // -Methods-
    //Save
    public Admin createAdmin(Admin adminData) throws Exception {
        try {
            return this.repository.save(adminData);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Find all
    public List<Admin> findAll() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Find by id
    public Admin findById(Integer id, Admin adminData) throws Exception {
        try {
            Optional<Admin> adminSearched = this.repository.findById(id);
            if (adminSearched.isPresent()) {
                return adminSearched.get();
            } else {
                throw new Exception("El Administrador no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Update by Id
    public Admin updateById(Integer id, Admin adminData) throws Exception {
        try {
            Optional<Admin> adminSearched = this.repository.findById(id);
            if (adminSearched.isPresent()) {
                adminSearched.get().setName(adminData.getName());
                adminSearched.get().setEmail(adminData.getEmail());
                adminSearched.get().setPhone(adminData.getPhone());
                adminSearched.get().setDocumentNumber(adminData.getDocumentNumber());
                adminSearched.get().setIdentificationType(adminData.getIdentificationType());
                adminSearched.get().setAdminCode(adminData.getAdminCode());
                if (adminData.getPassword()!=null && !adminData.getPassword().trim().isEmpty()){
                    adminSearched.get().setPassword(adminData.getPassword());
                }
                return this.repository.save(adminSearched.get());
            } else {
                throw new Exception("El Administrador no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteById(Integer id) throws Exception {

        try {
            Optional<Admin> adminSearched = this.repository.findById(id);
            if (adminSearched.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("El Administrador que quieres eliminar no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
