package com.restapi.airlines.model.Request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NotNull
public class TransactionRequestModel {

    private String idUser;

    private String idAirline;

    private String destinationAirline;

}
