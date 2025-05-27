package com.C2KProyect.Api_Rest_C2K.services;

import com.C2KProyect.Api_Rest_C2K.models.Customer;
import com.C2KProyect.Api_Rest_C2K.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    //Implements Repositories
    @Autowired
    ICustomerRepository repository;

    //--Methods--

    //Save-->
    public Customer createCustomer(Customer customerData)throws Exception{
        try {
            return this.repository.save(customerData);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Find all -->
    public List<Customer> findAll()throws Exception{
        try {
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Find by id -->
    public Customer findById(Integer id)throws Exception{
        try{
            Optional<Customer> customerSearched=this.repository.findById(id);
            if (customerSearched.isPresent()){
                return customerSearched.get();
            }else{
                throw new Exception("El cliente no se encuentra en la base de datos");
            }
        }
        catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Update by Id -->
    public Customer updateCustomer(Integer id, Customer customerData) throws Exception {
        try {
            Optional<Customer> customerSearched = this.repository.findById(id);
            if (customerSearched.isPresent()) {
                Customer existingCustomer = customerSearched.get();
                existingCustomer.setName(customerData.getName());
                existingCustomer.setEmail(customerData.getEmail());
                existingCustomer.setPassword(customerData.getPassword());
                existingCustomer.setPhone(customerData.getPhone());

                return this.repository.save(existingCustomer);
            } else {
                throw new Exception("El cliente no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Delete by Id -->
    public boolean deleteCustomer(Integer id)throws Exception{
        try {
            Optional<Customer>customerSearched=this.repository.findById(id);
            if (customerSearched.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else{
                throw new Exception("El cliente que quieres eliminar no se encuentra en la base de datos");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
