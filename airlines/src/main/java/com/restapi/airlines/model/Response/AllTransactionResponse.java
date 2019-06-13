package com.restapi.airlines.model.Response;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Setter
@Getter
public class AllTransactionResponse {
    private Collection transaction;
    private double totalTransaction = 0.00;
}
