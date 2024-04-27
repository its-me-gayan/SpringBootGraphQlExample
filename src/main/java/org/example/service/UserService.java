package org.example.service;

import org.example.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsersWithPagination(int count , int offset);
}
