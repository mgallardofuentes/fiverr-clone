package com.example.Equipo3ProyectoFiverr.repositories;


import com.example.Equipo3ProyectoFiverr.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    boolean existsByEmail(String email);
}