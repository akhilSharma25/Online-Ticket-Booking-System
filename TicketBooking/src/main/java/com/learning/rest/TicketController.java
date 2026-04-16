package com.learning.rest;

import com.learning.model.Ticket;
import com.learning.service.ITicketService;
import com.learning.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private ITicketService service;

    @PostMapping("/book-ticket")
    public ResponseEntity<Integer> generateTicket(@RequestBody Ticket ticket){

        Integer id=service.bookTicket(ticket);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/get-ticket/{ticketId}")
    public  ResponseEntity<Ticket> getFullTicket(@PathVariable("ticketId") Integer id){
        Ticket ticket=service.getTicketById(id);
        return new ResponseEntity<Ticket>(ticket,HttpStatus.OK);
    }



    @PutMapping("cancel-ticket/{ticketId}")
    public  ResponseEntity<String> cancelTicket(@PathVariable("ticketId") Integer id){
        String res=service.cancelTicket(id);
        return new ResponseEntity<String>(res,HttpStatus.OK);
    }

    @GetMapping("get-all-ticket/{userId}")
    public  ResponseEntity<List<Ticket>> getAllTicket(@PathVariable("userId") Integer id){
        List<Ticket> res=service.getAllHistoryOfTicket(id);
        return new ResponseEntity<List<Ticket>>(res,HttpStatus.OK);
    }

    @PutMapping("/update-ticket")
    public ResponseEntity<String> updateTicket(@RequestBody Ticket ticket){
        String s=service.updateTicketDetails(ticket);
        return new ResponseEntity<String>(s, HttpStatus.CREATED);
    }





}
