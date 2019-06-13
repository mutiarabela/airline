package com.restapi.airlines.service;

import com.restapi.airlines.model.Request.UserDetailsRequestModel;
import com.restapi.airlines.model.Response.UserRest;

import java.util.Collection;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
    UserRest getUser(String userId);
    Collection<UserRest> getAllUser();
    UserRest updatePhoneNumUser(String userId, UserDetailsRequestModel userDetails);
    UserRest deleteUser(String userId);
}
