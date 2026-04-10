package com.learning.service;

import com.learning.Exception.TicketNotFoundException;
import com.learning.model.Ticket;
import com.learning.repo.ITicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements ITicketService{

    @Autowired
    private ITicketRepo repo;


    @Override
    public Integer bookTicket(Ticket ticket) {
        Ticket ticket1=repo.save(ticket);
        return ticket1.getTicketId();
    }

    @Override
    public Ticket getTicketById(Integer id) {

Optional<Ticket>optional = repo.findById(id);
if(optional.isPresent()){
    return optional.get();
}else{
    throw new TicketNotFoundException("Ticket Not Found for this id : "+id);
}
    }

    @Override
    public String cancelTicket(Integer id) {
        repo.deleteById(id);
        return "Ticket Cancel Successfully";
    }

    @Override
    public String updateTicketDetails(Ticket ticket) {
        repo.save(ticket);
        return "Ticket Updated Successfully";
    }

    @Override
    public List<Ticket> getAllHistoryOfTicket(Integer userId) {
        return repo.findByUserId(userId);
    }
}
