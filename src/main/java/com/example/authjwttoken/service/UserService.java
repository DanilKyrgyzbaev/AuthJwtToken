package com.example.authjwttoken.service;

import com.example.authjwttoken.domain.Role;
import com.example.authjwttoken.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void adRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUser();
}
