package com.learning.repo;

import com.learning.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPaymentRepo extends JpaRepository<Payment,Integer> {


    Optional<Payment> findByTicketId(Integer ticketId);
}
