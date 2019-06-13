package com.restapi.airlines.service;

import com.restapi.airlines.model.Request.TransactionRequestModel;
import com.restapi.airlines.model.Response.AllTransactionResponse;
import com.restapi.airlines.model.Response.TransactionResponse;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface TransactionService {
    TransactionResponse createTransaction(TransactionRequestModel transactionRequestModel);
    AllTransactionResponse getAllTransaction();
}
