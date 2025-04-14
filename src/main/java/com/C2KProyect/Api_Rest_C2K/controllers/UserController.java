package com.C2KProyect.Api_Rest_C2K.controllers;

import com.C2KProyect.Api_Rest_C2K.models.User;
import com.C2KProyect.Api_Rest_C2K.repositories.IUserRepository;
import com.C2KProyect.Api_Rest_C2K.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;

@RestController
@RequestMapping("/user")
public class UserController {
    //Implement Repository
    @Autowired
    UserService userService;

    //--Crud--

    //Save-->
    @PostMapping
    public ResponseEntity<?>save(@RequestBody User requestData){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createUser(requestData));
        }
        catch (Exception error){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    //Find all -->
    @GetMapping
    public ResponseEntity<?>findAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.userService.findAll());
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    //Find by id -->
    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable Integer id, @RequestBody User requestData){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.userService.findById(id));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    //Update-->
    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Integer id,@RequestBody User requestData){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.userService.updateById(id,requestData));
        }
        catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    //Delete-->
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.userService.deleteUser(id));
        }
        catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
}
