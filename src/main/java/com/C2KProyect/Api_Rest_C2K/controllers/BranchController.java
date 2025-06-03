package com.C2KProyect.Api_Rest_C2K.controllers;

import com.C2KProyect.Api_Rest_C2K.models.Branch;
import com.C2KProyect.Api_Rest_C2K.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/branch")
public class BranchController {

    //Implement Repository
    @Autowired
    BranchService branchService;

    //--Crud--

    //Save-->
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Branch requestData){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(this.branchService.createBranch(requestData));
        }
        catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    //Find all -->
    @GetMapping
    public ResponseEntity<?>findAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.branchService.findAll());
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    //Find by id -->
    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable Integer id, @RequestBody Branch requestData){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.branchService.findById(id));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    //Update-->
    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Integer id,@RequestBody Branch requestData){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.branchService.updateById(id,requestData));
        }
        catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    //Delete-->
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.branchService.deleteBranch(id));
        }
        catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

}
