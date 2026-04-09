package com.learning.service;

import com.learning.repo.ITicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService{

    @Autowired
    private ITicketRepo repo;


}
