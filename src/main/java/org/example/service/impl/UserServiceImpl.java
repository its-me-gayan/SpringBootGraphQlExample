package org.example.service.impl;

import org.example.dto.UserDto;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserDto> getAllUsersWithPagination(int count, int offset) {

        PageRequest pageRequest = PageRequest.of(count, offset);
        Page<User> all = userRepository.findAll(pageRequest);
       return all.map(user -> UserDto.builder().userRole(user.getUserRole())
                .id(user.getId())
                .firstName(user.getFirstName())
                .username(user.getUsername())
                .lastName(user.getLastName()).build()
        ).toList();
    }
}
