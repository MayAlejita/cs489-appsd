package edu.miu.cs.cs489.dentalsurgeryapp.service;

import edu.miu.cs.cs489.dentalsurgeryapp.model.User;

import java.util.List;

public interface UserService {
    User addNewUser(User newUser);
    User getUserById(Integer userId);
    User updateUser(User user);
    List<User> getAllUsers();
    void deleteUserById(Integer userId);
}
