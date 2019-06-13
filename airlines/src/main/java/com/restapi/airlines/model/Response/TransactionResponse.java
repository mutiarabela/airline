package com.restapi.airlines.model.Response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionResponse {
//    private String idUser;
    private String firstNameUser;
    private String lastNameUser;
    private String phoneNumUser;
    private String emailUser;
//    private String idAirline;
    private String nameAirline;
    private String destinationAirline;
    private double priceAirline;
    private double discountAirline;
    private double totPriceAirline;
}
