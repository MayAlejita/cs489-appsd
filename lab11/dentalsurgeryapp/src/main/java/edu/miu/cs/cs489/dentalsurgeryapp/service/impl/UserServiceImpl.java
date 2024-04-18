package edu.miu.cs.cs489.dentalsurgeryapp.service.impl;

import edu.miu.cs.cs489.dentalsurgeryapp.dto.request.UserRequest;
import edu.miu.cs.cs489.dentalsurgeryapp.dto.response.UserResponse;
import edu.miu.cs.cs489.dentalsurgeryapp.exception.UserNotFoundException;
import edu.miu.cs.cs489.dentalsurgeryapp.model.User;
import edu.miu.cs.cs489.dentalsurgeryapp.repository.UserRepository;
import edu.miu.cs.cs489.dentalsurgeryapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse addNewUser(UserRequest newUser) {
        User user = new User(null,
                newUser.username(), newUser.password(),
                newUser.firstName(), newUser.lastName(),
                newUser.email(), newUser.credentialsNonExpired(),
                newUser.accountNonExpired(), newUser.enabled(),
                newUser.accountNonLocked());
        User saveUser = userRepository.save(user);
        return new UserResponse(saveUser.getUserId(),
                saveUser.getUsername(), saveUser.getFirstName(),
                saveUser.getLastName(), saveUser.getEmail(),
                saveUser.isEnabled(), saveUser.isAccountNonExpired(),
                saveUser.isAccountNonLocked(), saveUser.isCredentialsNonExpired());
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username).orElse(null);
    }

    @Override
    public UserResponse updateUser(Integer userId, User updatedUser) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new UserNotFoundException(String.format("Error: User with Id, %d, is not found", userId));
        }
        user.setPassword(updatedUser.getPassword());
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setAccountNonExpired(updatedUser.isAccountNonExpired());
        user.setAccountNonLocked(updatedUser.isAccountNonLocked());
        user.setCredentialsNonExpired(updatedUser.isCredentialsNonExpired());
        user.setEnabled(updatedUser.isEnabled());
        User upUser = userRepository.save(user);
        return new UserResponse(upUser.getUserId(),
                upUser.getUsername(), upUser.getFirstName(),
                upUser.getLastName(), upUser.getEmail(),
                upUser.isEnabled(), upUser.isAccountNonExpired(),
                upUser.isAccountNonLocked(), upUser.isCredentialsNonExpired());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }
}
