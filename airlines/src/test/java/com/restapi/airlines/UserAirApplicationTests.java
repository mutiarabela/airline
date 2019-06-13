package com.restapi.airlines;

import com.restapi.airlines.model.Request.UserDetailsRequestModel;
import com.restapi.airlines.model.Response.UserRest;
import com.restapi.airlines.service.UserService;
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
public class UserAirApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void createUser(){
        UserDetailsRequestModel user = new UserDetailsRequestModel();
        user.setIdUser("1");
        user.setFirstNameUser("Mutiara");
        user.setLastNameUser("Bela");
        user.setPhoneNumUser("082111711170");
        user.setUserNameUser("mutiarabela");
        user.setEmailUser("bela@gmail.com");
        user.setPasswordUser("12345678");

        log.info("-------- Parameter that we POST [User] --------");
        log.info("idUser="+user.getIdUser());
        log.info("firstNameUser="+user.getFirstNameUser());
        log.info("lastNameUser="+user.getLastNameUser());
        log.info("phoneNumUser="+user.getPhoneNumUser());
        log.info("userNameUser="+user.getUserNameUser());
        log.info("emailUser="+user.getEmailUser());
        log.info("passwordUser="+user.getPasswordUser());

        UserRest create = userService.createUser(user);

        assertThat(create.getIdUser()).isEqualTo(user.getIdUser());
        assertThat(create.getFirstNameUser()).isEqualTo(user.getFirstNameUser());
        assertThat(create.getLastNameUser()).isEqualTo(user.getLastNameUser());
        assertThat(create.getPhoneNumUser()).isEqualTo(user.getPhoneNumUser());
        assertThat(create.getUserNameUser()).isEqualTo(user.getUserNameUser());
        assertThat(create.getEmailUser()).isEqualTo(user.getEmailUser());
        assertThat(create.getPasswordUser()).isEqualTo(user.getPasswordUser());

        log.info("----------- Posted Parameter [User] -----------");
        log.info(create.toString());
    }

    @Test
    public void getUser() {

        createUser();
        log.info("");

        String idUser  = "1";
        log.info("GET idUser=1");

        UserRest result = userService.getUser(idUser);
        assertThat(result.getFirstNameUser()).isEqualTo("Mutiara");
        assertThat(result.getLastNameUser()).isEqualTo("Bela");
        assertThat(result.getPhoneNumUser()).isEqualTo("082111711170");
        assertThat(result.getUserNameUser()).isEqualTo("mutiarabela");
        assertThat(result.getEmailUser()).isEqualTo("bela@gmail.com");
        assertThat(result.getPasswordUser()).isEqualTo("12345678");

        log.info("-------- Parameter that we GET --------");
        log.info(result.toString());
    }
}
