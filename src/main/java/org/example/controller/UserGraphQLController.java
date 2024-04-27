package org.example.controller;

import org.example.dto.UserDto;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class UserGraphQLController {

    @Autowired
private UserService userService;
    @QueryMapping
    public List<UserDto> searchAllCustomer(@Argument int count, @Argument int offset)throws Exception{

       return userService.getAllUsersWithPagination(count, offset);
    }
}
