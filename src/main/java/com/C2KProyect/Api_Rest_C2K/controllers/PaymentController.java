package com.C2KProyect.Api_Rest_C2K.controllers;

import com.C2KProyect.Api_Rest_C2K.models.Rental;
import com.C2KProyect.Api_Rest_C2K.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    //Methods
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Rental requestData) {
        try {
            return paymentService.createPayment();
        } catch (Exception error) {
            return error.getMessage();
        }
    }
}
