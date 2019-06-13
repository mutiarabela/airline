package com.restapi.airlines.service;

import com.restapi.airlines.model.Request.AirlineDetailsRequestModel;
import com.restapi.airlines.model.Response.AirlineRest;

import java.util.Collection;

public interface AirlineService {
    AirlineRest createAirline(AirlineDetailsRequestModel airlineDetails);
    AirlineRest getAirline(String idAirline);
    Collection<AirlineRest> getAllAirline();
    AirlineRest updatePriceAirline(String idAirline, AirlineDetailsRequestModel airlineDetails);
    AirlineRest deleteAirline(String airlineId);
}
