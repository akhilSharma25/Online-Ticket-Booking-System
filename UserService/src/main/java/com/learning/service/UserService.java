package com.learning.service;

import com.learning.model.Ticket;
import com.learning.model.User;
import com.learning.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserService implements IUserService{
    private  String url="http://localhost:8081/ticket/book-ticket";

    @Autowired
    private IUserRepo repo;
    @Autowired
    private WebClient webClient;


    @Override
    public Integer addUser(User user) {
        com.learning.model.User user1 = repo.save(user);
        return  user1.getUserId();
    }

    @Override
    public Integer bookTicket(Ticket ticket) {
        Integer ticketNumber=webClient.post().uri(url).bodyValue(ticket).retrieve().bodyToMono(Integer.class).block(); //block is synchron communication and subscribe for Asynchronous
        return ticketNumber;
    }

    @Override
    public Ticket getTicket(Integer id) {
        return webClient.get() // GET use karo
                .uri("http://localhost:8081/ticket/get-ticket/{ticketId}", id) // Yahan {ticketId} ki jagah 'id' aa jayega
                .retrieve()
                .bodyToMono(Ticket.class)
                .block(); // Blocking call (Synchronous)
    }
}
