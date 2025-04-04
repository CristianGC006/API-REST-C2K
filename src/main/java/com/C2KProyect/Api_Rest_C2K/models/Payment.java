package com.C2KProyect.Api_Rest_C2K.models;

import com.C2KProyect.Api_Rest_C2K.helpers.enums.PaymentEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Integer idPayment;
    @Column(name = "payment_method")
    private PaymentEnum paymentMethod;
    @Column(name = "amount")
    private Double amount;

    public Payment() {
    }
    public Payment(Integer idPayment, PaymentEnum paymentMethod, Double amount) {
        this.idPayment = idPayment;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }
    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public PaymentEnum getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentEnum paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
