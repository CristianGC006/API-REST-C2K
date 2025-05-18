package com.C2KProyect.Api_Rest_C2K.services;

import com.C2KProyect.Api_Rest_C2K.models.LogisticOperator;
import com.C2KProyect.Api_Rest_C2K.models.Payment;
import com.C2KProyect.Api_Rest_C2K.models.Rental;
import com.C2KProyect.Api_Rest_C2K.repositories.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    IPaymentRepository repository;
    // -Methods-

    //Save
    public Payment createPayment(Payment paymentData) throws Exception {
        try{
            return this.repository.save(paymentData);

        }
        catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Find all
    public List<Payment> findAll() throws Exception {
        try{
            return this.repository.findAll();
        }
        catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Find by id

    public Payment findById(Integer id) throws Exception {
        try {
            Optional<Payment> paymentSearched = this.repository.findById(id);
            if (paymentSearched.isPresent()){
                return (Payment) paymentSearched.get();
            } else {
                throw new Exception("El pago no se encuentra en la base de datos");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    //Update by Id -->

    public Payment updateById(Integer id, Payment paymentData) throws Exception {
        try {
            Optional<Payment> paymentSearched = this.repository.findById(id);
            if (paymentSearched.isPresent()) {
                paymentSearched.get().setAmount(paymentData.getAmount());
                paymentSearched.get().setRental(paymentData.getRental());
                return this.repository.save(paymentSearched.get());
            } else {
                throw new Exception("El pago no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    //Delete by Id -->
    public boolean deleteById(Integer id) throws Exception {

        try {
            Optional<Payment> paymentSearched = this.repository.findById(id);
            if (paymentSearched.isPresent()) {
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
