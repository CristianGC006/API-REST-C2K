package com.C2KProyect.Api_Rest_C2K.services;

import com.C2KProyect.Api_Rest_C2K.helpers.enums.UserEnum;
import com.C2KProyect.Api_Rest_C2K.models.Assessor;
import com.C2KProyect.Api_Rest_C2K.models.User;
import com.C2KProyect.Api_Rest_C2K.repositories.IAssessorRepository;
import com.C2KProyect.Api_Rest_C2K.repositories.IUserRepository;
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
    @Autowired
    IUserRepository userRepository;

    //--Methods--

    //Save-->
    public Assessor createAssessorFromUser(Integer idUser, Assessor assessorData) throws Exception {
        try {
            // Verificar si ya existe un asesor con el mismo idUser
            Optional<Assessor> existingAssessor = repository.findById(idUser);
            if (existingAssessor.isPresent()) {
                throw new Exception("Ya existe un asesor asociado al ID de usuario proporcionado.");
            }

            Optional<User> userOptional = userRepository.findById(idUser);
            if (userOptional.isPresent()) {
                User user = userOptional.get();

                // Crear un nuevo asesor usando los datos del usuario
                Assessor assessor = new Assessor();
                assessor.setName(user.getName());
                assessor.setEmail(user.getEmail());
                assessor.setPassword(user.getPassword());
                assessor.setUserType(UserEnum.ASSESSOR); // Cambiar el tipo de usuario a ASSESSOR
                assessor.setPhone(user.getPhone());
                assessor.setAddress(user.getAddress());

                // Agregar datos específicos del asesor
                assessor.setBranch(assessorData.getBranch());
                assessor.setRentals(assessorData.getRentals());

                // Guardar el asesor en la base de datos
                return repository.save(assessor);
            } else {
                throw new Exception("El usuario con el ID proporcionado no existe.");
            }
        } catch (Exception e) {
            throw new Exception("Error al crear el asesor: " + e.getMessage());
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
    public Assessor updateAssessor(Integer id, Assessor assessorData) throws Exception {
        try {
            Optional<Assessor> assessorSearched = this.repository.findById(id);
            if (assessorSearched.isPresent()) {
                Assessor existingAssessor = assessorSearched.get();

                // Actualizar campos heredados de User
                existingAssessor.setName(assessorData.getName());
                existingAssessor.setEmail(assessorData.getEmail());
                existingAssessor.setPassword(assessorData.getPassword());
                existingAssessor.setUserType(assessorData.getUserType());
                existingAssessor.setPhone(assessorData.getPhone());
                existingAssessor.setAddress(assessorData.getAddress());

                // Actualizar campos específicos de Assessor
                existingAssessor.setBranch(assessorData.getBranch());
                existingAssessor.setRentals(assessorData.getRentals());

                // Guardar cambios
                return this.repository.save(existingAssessor);
            } else {
                throw new Exception("El asesor no se encuentra en la base de datos");
            }
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
