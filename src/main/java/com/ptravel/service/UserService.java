package com.ptravel.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import com.ptravel.pojos.User;


public interface UserService extends UserDetailsService {
    boolean addUser(User user, String role);
    List<User> getUsers(String email);
    List<User> getListUsers();
    User updateUser(int userId, User user);
    User getUserById(int id);
    boolean updateAvatar(int userId, MultipartFile avatar);
}
