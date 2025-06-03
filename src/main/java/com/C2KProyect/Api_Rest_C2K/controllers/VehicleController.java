package com.C2KProyect.Api_Rest_C2K.controllers;

import com.C2KProyect.Api_Rest_C2K.models.Vehicle;
import com.C2KProyect.Api_Rest_C2K.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    //--Crud--

    // Guardar un vehículo
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Vehicle requestData) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.vehicleService.createVehicle(requestData));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Obtener todos los vehículos
    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.vehicleService.findAll());
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Buscar vehículo por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.vehicleService.findById(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Actualizar un vehículo por ID
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Vehicle requestData) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.vehicleService.updateById(id, requestData));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    // Eliminar un vehículo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.vehicleService.deleteVehicle(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
}