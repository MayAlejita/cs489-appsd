package edu.miu.cs.cs489.dentalsurgeryapp.service;

import edu.miu.cs.cs489.dentalsurgeryapp.dto.request.UserRequest;
import edu.miu.cs.cs489.dentalsurgeryapp.dto.response.UserResponse;
import edu.miu.cs.cs489.dentalsurgeryapp.exception.UserNotFoundException;
import edu.miu.cs.cs489.dentalsurgeryapp.model.User;

import java.util.List;

public interface UserService {
    UserResponse addNewUser(UserRequest newUser);
    User getUserById(Integer userId);
    User getUserByUsername(String username);
    UserResponse updateUser(Integer userId, User user) throws UserNotFoundException;
    List<User> getAllUsers();
    void deleteUserById(Integer userId);
}
