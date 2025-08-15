package com.qms.backend.controller;

import com.qms.backend.user.CustomUserDetailsService;
import com.qms.backend.user.PasswordChangeRequest;
import com.qms.backend.user.User;
import com.qms.backend.user.UserService;
import com.qms.backend.util.AuthRequest;
import com.qms.backend.util.AuthResponse;
import com.qms.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @PostMapping("/test")
    public String test() {
        return "Controller works!";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            // Return 401 Unauthorized with message
            return ResponseEntity.status(401).body("Invalid username or password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }
    
    @PostMapping("/auth/change-password")
    public ResponseEntity<?> changePassword(@RequestBody PasswordChangeRequest request) {
        User user = userService.getUserByUsername(request.getUsername());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (!JwtUtil.PasswordPolicy.isValid(request.getNewPassword())) {
            return ResponseEntity.badRequest().body("Password does not meet policy requirements.");
        }

        if (encoder.matches(request.getNewPassword(), user.getPassword()) ||
                encoder.matches(request.getNewPassword(), user.getLastPassword1()) ||
                encoder.matches(request.getNewPassword(), user.getLastPassword2())) {
            return ResponseEntity.badRequest().body("New password must not match last 2 passwords.");
        }

        user.setPassword(request.getNewPassword());
        user.setIntialPasswordChanged(true);
        userService.updateUser(user);
        return ResponseEntity.ok("Password changed successfully.");
    }
}
