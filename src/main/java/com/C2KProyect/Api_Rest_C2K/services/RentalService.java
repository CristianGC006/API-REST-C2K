package com.C2KProyect.Api_Rest_C2K.services;

import com.C2KProyect.Api_Rest_C2K.models.Rental;
import com.C2KProyect.Api_Rest_C2K.repositories.IRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {

    @Autowired
    IRentalRepository repository;

    // Crear un nuevo alquiler
    public Rental createRental(Rental rentalData) throws Exception {
        try {
            return this.repository.save(rentalData);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Obtener todos los alquileres
    public List<Rental> findAll() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    // Buscar alquiler por ID
    public Rental findById(Integer id) throws Exception {
        try {
            Optional<Rental> rentalSearched = this.repository.findById(id);
            if (rentalSearched.isPresent()) {
                return rentalSearched.get();
            } else {
                throw new Exception("El alquiler no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Actualizar alquiler por ID
    public Rental updateById(Integer id, Rental rentalData) throws Exception {
        try {
            Optional<Rental> rentalSearched = this.repository.findById(id);
            if (rentalSearched.isPresent()) {
                Rental existingRental = rentalSearched.get();
                existingRental.setName(rentalData.getName());
                existingRental.setDescription(rentalData.getDescription());
                existingRental.setPrice(rentalData.getPrice());
                return this.repository.save(existingRental);
            } else {
                throw new Exception("El alquiler que quieres modificar no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar alquiler por ID
    public boolean deleteRental(Integer id) throws Exception {
        try {
            Optional<Rental> rentalSearched = this.repository.findById(id);
            if (rentalSearched.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("El alquiler que quieres eliminar no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}