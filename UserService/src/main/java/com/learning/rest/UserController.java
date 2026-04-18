package com.learning.rest;

import com.learning.model.Ticket;
import com.learning.model.User;
import com.learning.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private IUserService service;

    @PostMapping("sign-in")
    public Integer addUser(@RequestBody User user){
            return  service.addUser(user);
    }

    @PostMapping("book-ticket")
    public  Integer bookTicket(@RequestBody Ticket ticket){
        return service.bookTicket(ticket);
    }

    @GetMapping("/get-price")
    public Double getPrice(@RequestParam String source, @RequestParam String destination) {
        return Math.random() * 500 + 100; // Example: 100 to 600 ke beech
    }


    @GetMapping("/get-ticket/{ticketId}")
    public ResponseEntity<Ticket> getTicket(@PathVariable("ticketId") Integer id){
        Ticket ticket= service.getTicket(id);
        return  new ResponseEntity<>(ticket, HttpStatus.OK);
    }


//    public Integer bookTicket(@RequestBody User user){
//
//
//    }
//
//    @PostMapping("login")
//    public String addUser(@RequestBody User user){
//
//    }
}
