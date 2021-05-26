package com.dtits.springsecurity.dao;

import com.dtits.springsecurity.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
