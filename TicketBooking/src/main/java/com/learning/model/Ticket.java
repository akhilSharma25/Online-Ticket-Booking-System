package com.learning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    private Integer ticketId;
    private String destination;
    private  String source;
    private String travel_date;
    private String status;
    private Double total_price;
    private Integer userId;
}
