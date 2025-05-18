package com.C2KProyect.Api_Rest_C2K.services;

import com.C2KProyect.Api_Rest_C2K.models.User;
import com.C2KProyect.Api_Rest_C2K.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    //Implements Repositories
    @Autowired
    IUserRepository repository;


    //--Methods--

    //Save-->
    public User createUser(User userData)throws Exception{
        try{
            return this.repository.save(userData);
        }
        catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Find all -->
    public List<User> findAll()throws Exception{
        try{
            return this.repository.findAll();
        } catch (Exception error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    //Find by id -->
    public User findById(Integer id)throws Exception{
        try{
            Optional<User>userSearched=this.repository.findById(id);
            if (userSearched.isPresent()){
                return(User) userSearched.get();
            }else{
                throw new Exception("El usuario no se encuentra en la base de datos");
            }
        }
        catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Update by Id -->
    public User updateById(Integer id, User userData)throws Exception{
        try {
          Optional<User>userSearched=this.repository.findById(id);
          if (userSearched.isPresent()){
              userSearched.get().setName(userData.getName());
              userSearched.get().setEmail(userData.getEmail());
              userSearched.get().setPassword(userData.getPassword());
              userSearched.get().setPhone(userData.getPhone());
              userSearched.get().setAddress(userData.getAddress());
          }else{
              throw new Exception("El usuario que quieres modificar no se encuentra en la base de datos");
          }
          return this.repository.save(userSearched.get());
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Delete by Id -->
    public boolean deleteUser(Integer id)throws Exception{
        try {
            Optional<User>userSearched=this.repository.findById(id);
            if (userSearched.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else{
                throw new Exception("El usuario que quieres eliminar no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
