package com.social.dao;

import com.social.entities.Payment;
import com.social.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findById(Long id);
    List<Payment>findByUser(User user);
}
