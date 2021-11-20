package com.example.Equipo3ProyectoFiverr.repositories;


import com.example.Equipo3ProyectoFiverr.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findRoleByName(String name);
}