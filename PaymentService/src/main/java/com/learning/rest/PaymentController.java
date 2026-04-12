package com.learning.rest;

import com.learning.model.Payment;
import com.learning.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentController {

    @Autowired
    private IPaymentService service;

    @PostMapping("/process-payment")
     public ResponseEntity<Map<String, String>> doPayment(@RequestBody Payment payment){

        Payment p=service.paymentProcess(payment);
        Map<String, String> response = new HashMap<>();
        response.put("status", p.getPaymentStatus());
        response.put("transactionId",p.getTransactionId().toString());

        return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);

     }
}
