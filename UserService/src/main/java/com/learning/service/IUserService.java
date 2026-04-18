package com.learning.service;

import com.learning.model.Ticket;
import com.learning.model.User;

public interface IUserService {

    public Integer addUser(User user);
    public Integer bookTicket(Ticket ticket);
    public Ticket getTicket(Integer id);
}
