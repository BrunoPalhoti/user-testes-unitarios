package com.isadora.user.services;

import com.isadora.user.domain.User;

import java.util.List;

public interface UserService {
    User findById (Integer id);
    List<User> findAll();
}
