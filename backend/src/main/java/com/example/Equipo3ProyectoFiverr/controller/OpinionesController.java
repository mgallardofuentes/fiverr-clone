package com.example.Equipo3ProyectoFiverr.controller;


import com.example.Equipo3ProyectoFiverr.entities.Categorias;
import com.example.Equipo3ProyectoFiverr.entities.Empleadores;
import com.example.Equipo3ProyectoFiverr.entities.Opiniones;
import com.example.Equipo3ProyectoFiverr.entities.Trabajos;
import com.example.Equipo3ProyectoFiverr.repositories.CategoriasRepository;
import com.example.Equipo3ProyectoFiverr.repositories.OpinionesRepository;
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
public class OpinionesController {

    private final Logger log = LoggerFactory.getLogger(OpinionesController.class);

    private OpinionesRepository opinionesRepository;
    private TrabajosRepository trabajosRepository;
    private CategoriasRepository categoriasRepository;

    public OpinionesController(OpinionesRepository opinionesRepository, TrabajosRepository trabajosRepository,
                               CategoriasRepository categoriasRepository) {
        this.opinionesRepository = opinionesRepository;
        this.trabajosRepository = trabajosRepository;
        this.categoriasRepository = categoriasRepository;
    }

    /**
     * Buscar todas las opiniones en Base de Datos
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/api/opiniones")
    public List<Opiniones> findAll() {
        return opinionesRepository.findAll();
    }

    /**
     * Buscar opiniones por  id
     * Request
     * Response
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/api/opiniones/{id}")
    public ResponseEntity<Opiniones> findById(@PathVariable Long id) {
        Optional<Opiniones> opinionesOpt =opinionesRepository.findById(id);
        if (opinionesOpt.isPresent()) {
            return ResponseEntity.ok(opinionesOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crear nueva opinión en la bbdd.
     *
     * @param opinion
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/api/opiniones")
    public ResponseEntity<Opiniones> create(@RequestBody Opiniones opinion) {
        if (opinion.getId() != null) {
            log.warn("Intentando crear una opinion con id");
            return ResponseEntity.badRequest().build();
        }

        Opiniones result = opinionesRepository.save(opinion);
        return ResponseEntity.ok(result);
    }

    /**
     * Actualizar una opinion en la bbdd.
     *
     * @param opinion
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/api/opiniones")
    public ResponseEntity<Opiniones> update(@RequestBody Opiniones opinion) {
        if (opinion.getId() == null) {
            log.warn("Intentando actualizar una opinion sin dar el id");
            return ResponseEntity.badRequest().build();
        }
        if (!opinionesRepository.existsById(opinion.getId())) {
            log.warn("Intentando actualizar una opinion con id inexistente");
            return ResponseEntity.notFound().build();
        }

        Opiniones result = opinionesRepository.save(opinion);
        return ResponseEntity.ok(result);
    }

    /**
     * Eliminar una opinion de la bbdd.
     *
     * @param id
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/api/opiniones/{id}")
    public ResponseEntity<Opiniones> delete(@PathVariable Long id) {

        if (!opinionesRepository.existsById(id)) {
            log.warn("Intentando eliminar una opinión inexistente");
            return ResponseEntity.notFound().build();
        }

        opinionesRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Eliminar todas las opiniones de la base de datos
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/api/opiniones")
    public ResponseEntity<Opiniones> deleteAll() {
        log.info("Petición REST para eliminar todas las opiniones");


        opinionesRepository.deleteAll();

        return ResponseEntity.noContent().build();
    }



}
