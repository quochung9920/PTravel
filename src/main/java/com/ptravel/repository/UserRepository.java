package com.ptravel.repository;

import java.util.List;

import com.ptravel.pojos.User;


public interface UserRepository {
    boolean addUser(User user);
    List<User> getUsers(String email);
    List<User> getListUsers();
    User updateUser(User user, int userId);
    User getUserById(int id);
    boolean updateAvatar(int userId, String avatar);
}
