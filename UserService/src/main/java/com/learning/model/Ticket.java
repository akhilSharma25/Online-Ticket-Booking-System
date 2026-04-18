package com.learning.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {


    private String destination;
    private  String source;
    private Integer ticketId;

    private String travel_date;
    private Double total_price;
    private String status;
    private Integer userId;
}
