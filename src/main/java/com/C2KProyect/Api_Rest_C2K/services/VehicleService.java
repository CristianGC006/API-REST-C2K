package com.C2KProyect.Api_Rest_C2K.services;

import com.C2KProyect.Api_Rest_C2K.models.Vehicle;
import com.C2KProyect.Api_Rest_C2K.repositories.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    // Repositorio
    @Autowired
    IVehicleRepository repository;

    // Crear un nuevo vehículo
    public Vehicle createVehicle(Vehicle vehicleData) throws Exception {
        try {
            return this.repository.save(vehicleData);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Obtener todos los vehículos
    public List<Vehicle> findAll() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    // Buscar vehículo por ID
    public Vehicle findById(Integer id) throws Exception {
        try {
            Optional<Vehicle> vehicleSearched = this.repository.findById(id);
            if (vehicleSearched.isPresent()) {
                return vehicleSearched.get();
            } else {
                throw new Exception("El vehículo no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Actualizar vehículo por ID
    public Vehicle updateById(Integer id, Vehicle vehicleData) throws Exception {
        try {
            Optional<Vehicle> vehicleSearched = this.repository.findById(id);
            if (vehicleSearched.isPresent()) {
                Vehicle existingVehicle = vehicleSearched.get();
                existingVehicle.setBrand(vehicleData.getBrand());
                existingVehicle.setModel(vehicleData.getModel());
                existingVehicle.setColor(vehicleData.getColor());
                existingVehicle.setPlate(vehicleData.getPlate());
                existingVehicle.setYear(vehicleData.getYear());
                existingVehicle.setType(vehicleData.getType());
                return this.repository.save(existingVehicle);
            } else {
                throw new Exception("El vehículo que quieres modificar no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar vehículo por ID
    public boolean deleteVehicle(Integer id) throws Exception {
        try {
            Optional<Vehicle> vehicleSearched = this.repository.findById(id);
            if (vehicleSearched.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("El vehículo que quieres eliminar no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}