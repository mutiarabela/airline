package com.restapi.airlines.service.implement;

import com.restapi.airlines.model.Request.AirlineDetailsRequestModel;
import com.restapi.airlines.model.Response.AirlineRest;
import com.restapi.airlines.service.AirlineService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class AirlineServiceImplemet implements AirlineService {
    AirlineRest returnValue;

    HashMap<String, AirlineRest> airlines;

    @Override
    public AirlineRest createAirline(AirlineDetailsRequestModel airlineDetails) {
        returnValue = new AirlineRest();

        returnValue.setIdAirline(airlineDetails.getIdAirline());
        String idAirline = returnValue.getIdAirline();

        returnValue.setIdAirline(airlineDetails.getIdAirline());
        returnValue.setNameAirline(airlineDetails.getNameAirline());
        returnValue.setTypeAirline(airlineDetails.getTypeAirline());
        returnValue.setDestinationAirline(airlineDetails.getDestinationAirline());
        returnValue.setAirportOriginAirline(airlineDetails.getAirportOriginAirline());
        returnValue.setAirportDestinationAirline(airlineDetails.getAirportDestinationAirline());
        returnValue.setDestinationAirline(airlineDetails.getDestinationAirline());
        returnValue.setPriceAirline(airlineDetails.getPriceAirline());
        returnValue.setDiscountAirline(airlineDetails.getDiscountAirline());

        if (airlines == null) {
            airlines = new HashMap<>();
        }

        airlines.put(idAirline, returnValue);
        return returnValue;
    }

    public AirlineRest getAirline (String idAirline) { return airlines.get(idAirline); }

    public Collection<AirlineRest> getAllAirline(){
        return airlines.values();
    }

    public AirlineRest deleteAirline(String idAirline){ return airlines.remove(idAirline); }

    public AirlineRest updatePriceAirline (String idAirline, AirlineDetailsRequestModel airlineDetails) {
        if(airlines.containsKey(idAirline)){
            AirlineRest storedUser = airlines.get(idAirline);
            storedUser.setPriceAirline(airlineDetails.getPriceAirline());

            airlines.put(idAirline, storedUser);
        }
        return airlines.get(idAirline);
    }
}
