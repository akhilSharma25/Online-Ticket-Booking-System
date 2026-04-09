package com.learning.repo;

import com.learning.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepo extends JpaRepository<Ticket,Integer> {
}
