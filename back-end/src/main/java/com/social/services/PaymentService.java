package com.social.services;

import com.social.dao.PaymentRepository;
import com.social.entities.Payment;
import com.social.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
private final
PaymentRepository paymentRepository;


    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    public List<Payment>getAllPaymentsByUser(User user){
        return paymentRepository.findByUser(user);
    }
    public List<Payment>getAllPayments(){
        return paymentRepository.findAll();
    }
    public Payment save(Payment payment){
        return paymentRepository.saveAndFlush(payment);
    }
}
