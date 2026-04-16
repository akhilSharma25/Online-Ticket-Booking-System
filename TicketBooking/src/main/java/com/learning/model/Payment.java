package com.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Payment {


    private String paymentDate;
    private String paymentStatus;
    private Double amount;
    private Integer ticketId;
}
