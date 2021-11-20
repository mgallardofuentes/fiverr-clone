package com.example.Equipo3ProyectoFiverr.controller;


import com.example.Equipo3ProyectoFiverr.entities.Categorias;
import com.example.Equipo3ProyectoFiverr.entities.Empleadores;
import com.example.Equipo3ProyectoFiverr.entities.Trabajos;
import com.example.Equipo3ProyectoFiverr.repositories.CategoriasRepository;
import com.example.Equipo3ProyectoFiverr.repositories.EmpleadoresRepository;
import com.example.Equipo3ProyectoFiverr.repositories.TrabajosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class EmpleadoresController {

    private final Logger log = LoggerFactory.getLogger(EmpleadoresController.class);

    private EmpleadoresRepository empleadoresRepository;
    private TrabajosRepository trabajosRepository;

    public EmpleadoresController(EmpleadoresRepository empleadoresRepository, TrabajosRepository trabajosRepository) {
        this.empleadoresRepository = empleadoresRepository;
        this.trabajosRepository = trabajosRepository;
    }

    /**
     * Buscar todos los empleadores en Base de Datos
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/api/empleadores")
    public List<Empleadores> findAll() {
        return empleadoresRepository.findAll();
    }

    /**
     * Buscar empleadores por  id
     * Request
     * Response
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/api/empleadores/{id}")
    public ResponseEntity<Empleadores> findById(@PathVariable Long id) {
        Optional<Empleadores> empleadoresOpt = empleadoresRepository.findById(id);
        if (empleadoresOpt.isPresent()) {
            return ResponseEntity.ok(empleadoresOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crear empleado nuevo en la bbdd.
     *
     * @param empleador
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/api/empleadores")
    public ResponseEntity<Empleadores> create(@RequestBody Empleadores empleador) {
        if (empleador.getId() != null) {
            log.warn("Intentando crear un empleado con id");
            return ResponseEntity.badRequest().build();
        }
        List<Empleadores> empleadores = empleadoresRepository.findAll();
        for (Empleadores empleadorEnRepo : empleadores) {
            if (empleadorEnRepo.getNombre().equals(empleador.getNombre())) {
                log.warn("Intentando crear un empleador ya existente");
                return ResponseEntity.badRequest().build();
            }
        }

        Empleadores result = empleadoresRepository.save(empleador);
        return ResponseEntity.ok(result);
    }

    /**
     * Actualizar un empleador en la bbdd.
     *
     * @param empleador
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/api/empleadores")
    public ResponseEntity<Empleadores> update(@RequestBody Empleadores empleador) {
        if (empleador.getId() == null) {
            log.warn("Intentando actualizar un empleador sin dar el id");
            return ResponseEntity.badRequest().build();
        }
        if (!empleadoresRepository.existsById(empleador.getId())) {
            log.warn("Intentando actualizar un empleaador con id inexistente");
            return ResponseEntity.notFound().build();
        }

        Empleadores result = empleadoresRepository.save(empleador);
        return ResponseEntity.ok(result);
    }

    /**
     * Eliminar un empleador de la bbdd.
     *
     * @param id
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/api/empleadores/{id}")
    public ResponseEntity<Empleadores> delete(@PathVariable Long id) {

        if (!empleadoresRepository.existsById(id)) {
            log.warn("Intentando eliminar un empleador inexistente");
            return ResponseEntity.notFound().build();
        }

        Optional<Empleadores> empleadorOpt = empleadoresRepository.findById(id);
        if (empleadorOpt.isPresent()) {
            Empleadores empleador = empleadorOpt.get();
            System.out.println(empleador );
            System.out.println(empleador.getTrabajos());
            Set<Trabajos> trabajos =empleador.getTrabajos();
            for (Trabajos trabajo : trabajos) {
                trabajo.removeEmpleador(empleador, false);
                trabajosRepository.save(trabajo);
            }
        }

        empleadoresRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Eliminar todos los empleadores de la base de datos
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/api/empleadores")
    public ResponseEntity<Empleadores> deleteAll() {
        log.info("Petición REST para eliminar todos los empleadores");
        List<Empleadores> empleadores = empleadoresRepository.findAll();

        for (Empleadores empleador: empleadores) {
            Set<Trabajos> trabajos = empleador.getTrabajos();
            for (Trabajos trabajo: trabajos) {
                trabajo.removeEmpleador(empleador, false);
                trabajosRepository.save(trabajo);
            }
        }

        empleadoresRepository.deleteAll();

        return ResponseEntity.noContent().build();
    }



}
