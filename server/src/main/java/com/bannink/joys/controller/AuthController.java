package com.bannink.joys.controller;

import com.bannink.joys.domain.ChallengeInformation;
import com.bannink.joys.domain.GameInformation;
import com.bannink.joys.domain.User;
import com.bannink.joys.payload.request.*;
import com.bannink.joys.payload.response.*;
import com.bannink.joys.repository.IChallengeInformationRepository;
import com.bannink.joys.repository.IUserRepository;
import com.bannink.joys.repository.IUserRepository;
import com.bannink.joys.response.ProfileResponse;
import com.bannink.joys.response.UserResponse;
import com.bannink.joys.service.AuthorizationService;

import com.bannink.joys.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Uitleg over CrossOrigin en CORS:
 * https://medium.com/@baphemot/understanding-cors-18ad6b478e2b
 *
 * Gebruik in Spring-boot (op controller en globally)
 * https://www.tutorialspoint.com/spring_boot/spring_boot_cors_support.htm
 *
 * Zoals je hieronder ziet, kun je ook op klasse-niveau een adres configureren. Iaw alle methodes hieronder, hebben
 * /api/auth voor de link staan.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthorizationService authorizationService;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IChallengeInformationRepository challengeInformationRepository;

    @PostMapping("/signin")
    public ResponseEntity<UserResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return authorizationService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@RequestBody SignupRequest signUpRequest) {
        return authorizationService.registerUser(signUpRequest);
    }

}
