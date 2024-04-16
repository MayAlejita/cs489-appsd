package edu.miu.cs.cs489.dentalsurgeryapp.controller;

import edu.miu.cs.cs489.dentalsurgeryapp.dto.request.UserAuthRequest;
import edu.miu.cs.cs489.dentalsurgeryapp.dto.response.UserAuthResponse;
import edu.miu.cs.cs489.dentalsurgeryapp.service.UserService;
import edu.miu.cs.cs489.dentalsurgeryapp.service.util.JWTMgmtUtilityService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adsweb/api/v1/public/auth")
public class UserAuthController {
    private JWTMgmtUtilityService jwtMgmtUtilityService;
    private AuthenticationManager authenticationManager;
    private UserService userService;

    public UserAuthController(JWTMgmtUtilityService jwtMgmtUtilityService, AuthenticationManager authenticationManager, UserService userService, AuthenticationProvider authenticationProvider) {
        this.jwtMgmtUtilityService = jwtMgmtUtilityService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthResponse> authenticateUser(@RequestBody @Valid UserAuthRequest userAuthRequest) {
        UserAuthResponse userAuthResponse = null;
        try{
            var username = userAuthRequest.username();
            var password = userAuthRequest.password();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            var jwtToken = jwtMgmtUtilityService.generateToken(username);
            var user = userService.getUserByUsername(username);
            if(user != null) {
                userAuthResponse = new UserAuthResponse(jwtToken, user.getFirstName(), user.getLastName());
            }
        }
        catch (Exception ex){
            System.out.println("UserAuthException is: " + ex);
            throw ex;
        }
        return ResponseEntity.ok(userAuthResponse);
    }
}

