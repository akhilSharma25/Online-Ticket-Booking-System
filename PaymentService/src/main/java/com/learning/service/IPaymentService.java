package com.learning.service;

import com.learning.model.Payment;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPaymentService {

    public Payment paymentProcess(Payment pay);

}
