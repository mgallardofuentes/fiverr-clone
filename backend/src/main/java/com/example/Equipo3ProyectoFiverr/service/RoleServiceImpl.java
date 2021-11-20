package com.example.Equipo3ProyectoFiverr.service;



import com.example.Equipo3ProyectoFiverr.entities.Role;
import com.example.Equipo3ProyectoFiverr.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findRoleByName(name);
    }
}
