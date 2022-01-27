package com.isadora.user.services.impl;

import com.isadora.user.domain.User;
import com.isadora.user.repositotires.UserRepository;
import com.isadora.user.services.UserService;
import com.isadora.user.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("ID NOT FOUND"));
    }
}
