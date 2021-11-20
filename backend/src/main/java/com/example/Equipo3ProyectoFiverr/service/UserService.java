package com.example.Equipo3ProyectoFiverr.service;




import com.example.Equipo3ProyectoFiverr.dto.UserDto;
import com.example.Equipo3ProyectoFiverr.entities.User;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
}
