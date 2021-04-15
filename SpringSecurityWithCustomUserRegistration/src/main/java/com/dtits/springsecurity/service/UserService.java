package com.dtits.springsecurity.service;

import com.dtits.springsecurity.entity.User;
import com.dtits.springsecurity.user.CrmUser;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String username);

    void save(CrmUser crmUser);
}
