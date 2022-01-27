package com.isadora.user.services.impl;

import com.isadora.user.domain.User;
import com.isadora.user.domain.dto.UserDto;
import com.isadora.user.repositotires.UserRepository;
import com.isadora.user.services.UserService;
import com.isadora.user.services.exceptions.DataIntegratyViolationException;
import com.isadora.user.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("ID NOT FOUND"));
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User create(UserDto obj) {
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDto obj){
        Optional<User> user = userRepository.findByEmail(obj.getEmail());
        if (user.isPresent()){
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }
}
