package com.isadora.user.resource;

import com.isadora.user.config.ModelMapperConfig;
import com.isadora.user.domain.User;
import com.isadora.user.domain.dto.UserDto;
import com.isadora.user.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResoucer {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Integer id){
        return  ResponseEntity.ok().body(mapper.map(userService.findById(id), UserDto.class));
    }
}
