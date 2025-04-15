package com.C2KProyect.Api_Rest_C2K.controllers;

import com.C2KProyect.Api_Rest_C2K.models.Assessor;
import com.C2KProyect.Api_Rest_C2K.models.User;
import com.C2KProyect.Api_Rest_C2K.services.AssessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assessor")
public class AssessorController {

    //Implement Repository
    @Autowired
    AssessorService assessorService;

    //--Crud--

    //Save-->
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Assessor requestData){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(this.assessorService.createAssessor(requestData));
        }
        catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    //Find all -->
    @GetMapping
    public ResponseEntity<?>findAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.assessorService.findAll());
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    //Find by id -->
    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable Integer id, @RequestBody Assessor requestData){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.assessorService.findById(id));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    //Delete-->
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.assessorService.deleteAssessor(id));
        }
        catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

}
