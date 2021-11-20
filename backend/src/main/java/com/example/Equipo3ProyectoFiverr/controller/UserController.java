package com.example.Equipo3ProyectoFiverr.controller;



import com.example.Equipo3ProyectoFiverr.config.TokenProvider;
import com.example.Equipo3ProyectoFiverr.dto.AuthToken;
import com.example.Equipo3ProyectoFiverr.dto.LoginUser;
import com.example.Equipo3ProyectoFiverr.dto.UserDto;
import com.example.Equipo3ProyectoFiverr.entities.User;
import com.example.Equipo3ProyectoFiverr.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

    private AuthenticationManager authenticationManager;
    private TokenProvider jwtTokenUtil;
    private UserService userService;

    public UserController(AuthenticationManager authenticationManager, TokenProvider jwtTokenUtil, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }


    /*@CrossOrigin
    @PostMapping("/register")
    public User saveUser(@RequestBody UserDto user){

        return userService.save(user);
    }*/

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws AuthenticationException{

        userService.save(user);
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }





}
