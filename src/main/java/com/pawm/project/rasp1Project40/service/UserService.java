package com.pawm.project.rasp1Project40.service;

import com.pawm.project.rasp1Project40.model.User;
import com.pawm.project.rasp1Project40.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}
