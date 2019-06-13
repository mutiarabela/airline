package com.restapi.airlines.service.implement;

import com.restapi.airlines.model.Request.UserDetailsRequestModel;
import com.restapi.airlines.model.Response.UserRest;
import com.restapi.airlines.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class UserServiceImplement implements UserService {
    UserRest returnValue;

    HashMap<String, UserRest> users;

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        returnValue = new UserRest();

        returnValue.setIdUser(userDetails.getIdUser());
        String idUser = returnValue.getIdUser();

        returnValue.setIdUser(userDetails.getIdUser());
        returnValue.setFirstNameUser(userDetails.getFirstNameUser());
        returnValue.setLastNameUser(userDetails.getLastNameUser());
        returnValue.setPhoneNumUser(userDetails.getPhoneNumUser());
        returnValue.setUserNameUser(userDetails.getUserNameUser());
        returnValue.setEmailUser(userDetails.getEmailUser());
        returnValue.setPasswordUser(userDetails.getPasswordUser());

        if (users == null) {
            users = new HashMap<>();
        }

        users.put(idUser, returnValue);
        return returnValue;
    }

    public UserRest getUser (String idUser) {
        return users.get(idUser);
    }

    public Collection <UserRest> getAllUser(){
        return users.values();
    }

    public UserRest deleteUser(String idUser){
        return users.remove(idUser);
    }

    public UserRest updatePhoneNumUser (String idUser, UserDetailsRequestModel userDetails) {
        if(users.containsKey(idUser)){
            UserRest storedUser = users.get(idUser);
            storedUser.setPhoneNumUser(userDetails.getPhoneNumUser());

            users.put(idUser, storedUser);
        }
        return users.get(idUser);
    }
}
