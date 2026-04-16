package com.learning.service;


import com.learning.Exception.PaymentFailedException;
import com.learning.model.Payment;
import com.learning.repo.IPaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    private  IPaymentRepo repo;

    @Override
    public Payment paymentProcess(Payment pay) {

        Optional<Payment>check=repo.findByTicketId(pay.getTicketId());
        if(check.isPresent()){
            Payment p=check.get();
            if(p.getPaymentStatus().equals("Success")) return p;
            else pay = p;
}else {
            int randomId = new Random().nextInt(900000000) + 100000000;
            pay.setTransactionId(randomId);
        }

        String status = (Math.random() > 0.6) ? "Success" : "Failed";
        pay.setPaymentStatus(status);

        // Save ek hi baar
        Payment savedPayment = repo.save(pay);

        // Agar fail hua toh exception throw
        if ("Failed".equals(status)) {
            throw new PaymentFailedException("Transaction failed for Ticket ID: " + pay.getTicketId());
        }
        return savedPayment;
    }
}
