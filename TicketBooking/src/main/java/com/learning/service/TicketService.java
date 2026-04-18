package com.learning.service;

import com.learning.Exception.PaymentFailedException;
import com.learning.Exception.TicketNotFoundException;
import com.learning.model.Payment;
import com.learning.model.Ticket;
import com.learning.repo.ITicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TicketService implements ITicketService{

    @Autowired
    private ITicketRepo repo;
    @Autowired
    private RestTemplate restTemplate;
    private  String url="http://localhost:8082/payment/process-payment";


    @Override
    public Integer bookTicket(Ticket ticket) {
        Ticket ticket1=repo.save(ticket);

        Payment payment=new Payment();
        payment.setTicketId(ticket1.getTicketId());
//        payment.setAmount(Math.random()*1000);
        payment.setAmount(ticket1.getTotal_price());
        payment.setPaymentDate(LocalDateTime.now().toString());

        Map<String, String> response= restTemplate.postForEntity(url,payment, Map.class).getBody();
        if(response.containsKey("status") && response.get("status").equals("Success")){
            ticket1.setStatus("Success");
            ticket1.setTotal_price(payment.getAmount());
           ticket1= repo.save(ticket1);
            return ticket1.getTicketId();

        }else{
            ticket1.setStatus("FAILED"); repo.save(ticket1);
            throw new PaymentFailedException("Payment failed");
        }

    }

    @Override
    public Ticket getTicketById(Integer id) {

Optional<Ticket>optional = repo.findById(id);
if(optional.isPresent()){
    return optional.get();
}else{
    throw new TicketNotFoundException("Ticket Not Found for this ticketId : "+id);
}
    }

    @Override
    public String cancelTicket(Integer id) {
        Optional<Ticket>optional =repo.findById(id);
        if(optional.isPresent()){
           Ticket ticket= optional.get();
           ticket.setStatus("Cancel");

            repo.save(ticket);
            return "Ticket Cancel Successfully";

        }
else{
            throw new TicketNotFoundException("Ticket Not Found for this ticketId : "+id);

        }
    }

    @Override
    public String updateTicketDetails(Ticket ticket) {
        Optional<Ticket>optional =repo.findById(ticket.getTicketId());
        if(optional.isPresent()) {
            repo.save(ticket);
            return "Ticket Updated Successfully";
        }else{
            throw new TicketNotFoundException("Ticket Not Found for this ticketId");

        }

    }

    @Override
    public List<Ticket> getAllHistoryOfTicket(Integer userId) {
        return repo.findByUserId(userId);
    }
}
