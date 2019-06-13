package com.restapi.airlines;

import com.restapi.airlines.model.Request.AirlineDetailsRequestModel;
import com.restapi.airlines.model.Response.AirlineRest;
import com.restapi.airlines.service.AirlineService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AirlineAirApplicationTests {
    @Autowired
    AirlineService airlineService;

    @Test
    public void createAirline(){
        AirlineDetailsRequestModel airline = new AirlineDetailsRequestModel();
        airline.setIdAirline("1");
        airline.setNameAirline("Garuda");
        airline.setTypeAirline("Airplane");
        airline.setAirportOriginAirline("Soekarno Hatta");
        airline.setAirportDestinationAirline("Adi Soetjipto");
        airline.setDestinationAirline("Yogyakarta");
        airline.setPriceAirline(1250000.00);
        airline.setDiscountAirline(0);

        log.info("-------- Parameter that we POST [Airline] --------");
        log.info("idAirline="+airline.getIdAirline());
        log.info("nameAirline="+airline.getNameAirline());
        log.info("typeAirline="+airline.getTypeAirline());
        log.info("airportOriginAirline="+airline.getAirportOriginAirline());
        log.info("airportDestinationAirline="+airline.getAirportDestinationAirline());
        log.info("destinationAirline="+airline.getDestinationAirline());
        log.info("priceAirline="+airline.getPriceAirline());
        log.info("discountAirline="+airline.getDiscountAirline());

        AirlineRest create = airlineService.createAirline(airline);

        assertThat(create.getIdAirline()).isEqualTo(airline.getIdAirline());
        assertThat(create.getNameAirline()).isEqualTo(airline.getNameAirline());
        assertThat(create.getTypeAirline()).isEqualTo(airline.getTypeAirline());
        assertThat(create.getAirportOriginAirline()).isEqualTo(airline.getAirportOriginAirline());
        assertThat(create.getAirportDestinationAirline()).isEqualTo(airline.getAirportDestinationAirline());
        assertThat(create.getDestinationAirline()).isEqualTo(airline.getDestinationAirline());
        assertThat(create.getPriceAirline()).isEqualTo(airline.getPriceAirline());
        assertThat(create.getDiscountAirline()).isEqualTo(airline.getDiscountAirline());

        log.info("----------- Posted Parameter [Airline] -----------");
        log.info(create.toString());
    }

    @Test
    public void getAirline() {

        createAirline();
        log.info("");

        String idAirline  = "1";
        log.info("GET idAirline=1");

        AirlineRest result = airlineService.getAirline(idAirline);
        assertThat(result.getIdAirline()).isEqualTo("1");
        assertThat(result.getNameAirline()).isEqualTo("Garuda");
        assertThat(result.getTypeAirline()).isEqualTo("Airplane");
        assertThat(result.getAirportOriginAirline()).isEqualTo("Soekarno Hatta");
        assertThat(result.getAirportDestinationAirline()).isEqualTo("Adi Soetjipto");
        assertThat(result.getDestinationAirline()).isEqualTo("Yogyakarta");
        assertThat(result.getPriceAirline()).isEqualTo(1250000.00);
        assertThat(result.getDiscountAirline()).isEqualTo(0);

        log.info("-------- Parameter that we GET [Airline] --------");
        log.info(result.toString());
    }
}
