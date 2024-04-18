package edu.miu.cs.cs489.dentalsurgeryapp.controller;

import edu.miu.cs.cs489.dentalsurgeryapp.dto.request.UserRequest;
import edu.miu.cs.cs489.dentalsurgeryapp.dto.response.UserResponse;
import edu.miu.cs.cs489.dentalsurgeryapp.exception.UserNotFoundException;
import edu.miu.cs.cs489.dentalsurgeryapp.model.User;
import edu.miu.cs.cs489.dentalsurgeryapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adsweb/api/v1/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest) {
        UserResponse user = userService.addNewUser(userRequest);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Integer userId, @RequestBody User user) throws UserNotFoundException {
        return ResponseEntity.ok(userService.updateUser(userId, user));
    }
}
