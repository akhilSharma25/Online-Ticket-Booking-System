package com.learning.repo;

import com.learning.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITicketRepo extends JpaRepository<Ticket,Integer> {


    public List<Ticket> findByUserId(Integer userId);
}
