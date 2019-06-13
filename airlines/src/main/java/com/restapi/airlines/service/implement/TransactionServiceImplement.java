package com.restapi.airlines.service.implement;

import com.restapi.airlines.model.Request.TransactionRequestModel;
import com.restapi.airlines.model.Response.AirlineRest;
import com.restapi.airlines.model.Response.AllTransactionResponse;
import com.restapi.airlines.model.Response.TransactionResponse;
import com.restapi.airlines.model.Response.UserRest;
import com.restapi.airlines.service.AirlineService;
import com.restapi.airlines.service.TransactionService;
import com.restapi.airlines.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransactionServiceImplement implements TransactionService {
    @Autowired
    private UserService userService;

    @Autowired
    private AirlineService airlineService;

    TransactionResponse returnValue;

    HashMap<String, TransactionResponse> transactions;

    public TransactionResponse createTransaction(TransactionRequestModel transactionRequestModel){

        returnValue = new TransactionResponse();

        String idUser = transactionRequestModel.getIdUser();
        String idAirline = transactionRequestModel.getIdAirline();

        UserRest userTemp = userService.getUser(idUser);
        AirlineRest airlineTemp = airlineService.getAirline(idAirline);

        returnValue.setFirstNameUser(userTemp.getFirstNameUser());
        returnValue.setLastNameUser(userTemp.getLastNameUser());
        returnValue.setPhoneNumUser(userTemp.getPhoneNumUser());
        returnValue.setEmailUser(userTemp.getEmailUser());
        returnValue.setNameAirline(airlineTemp.getNameAirline());
        returnValue.setDestinationAirline(airlineTemp.getDestinationAirline());

        returnValue.setPriceAirline(airlineTemp.getPriceAirline());
        double priceAirline = returnValue.getPriceAirline();

        returnValue.setDiscountAirline(airlineTemp.getDiscountAirline());
        double discountPrice = returnValue.getDiscountAirline();

        double total = priceAirline - ((priceAirline * discountPrice)/100);
        returnValue.setTotPriceAirline(total);

        if (transactions == null) {
            transactions = new HashMap<>();
        }

        transactions.put(idUser,returnValue);

        return returnValue;
    }

    private double totalTransaction(){
        double total = 0.00;
        Map<String, TransactionResponse> map = transactions;
        for (Map.Entry<String, TransactionResponse> entry : map.entrySet()) {
            total += entry.getValue().getTotPriceAirline();
        }
        return total;
    }

    public AllTransactionResponse getAllTransaction(){
        AllTransactionResponse allTransactionResponse = new AllTransactionResponse();
        allTransactionResponse.setTransaction(transactions.values());
        allTransactionResponse.setTotalTransaction(totalTransaction());
        return allTransactionResponse;
    }
}
