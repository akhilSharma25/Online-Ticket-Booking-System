package com.learning.service;

import com.learning.model.Ticket;

import java.util.List;

public interface ITicketService {
    public Integer bookTicket(Ticket ticket);
    public Ticket getTicketById(Integer id);
    public String cancelTicket(Integer id);
    public  String updateTicketDetails(Ticket ticket);
    public List<Ticket> getAllHistoryOfTicket(Integer userId);
}
