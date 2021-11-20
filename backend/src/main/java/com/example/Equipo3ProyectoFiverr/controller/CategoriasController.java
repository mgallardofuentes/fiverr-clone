package com.example.Equipo3ProyectoFiverr.controller;


import com.example.Equipo3ProyectoFiverr.dto.TrabajosDto;
import com.example.Equipo3ProyectoFiverr.entities.Categorias;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class CategoriasController {

    private final Logger log = LoggerFactory.getLogger(CategoriasController.class);

    private CategoriasRepository categoriasRepository;
    private TrabajosRepository trabajosRepository;
    private OpinionesRepository opinionesRepository;

    public CategoriasController(CategoriasRepository categoriasRepository, TrabajosRepository trabajosRepository,
                                OpinionesRepository opinionesRepository) {
        this.categoriasRepository = categoriasRepository;
        this.trabajosRepository = trabajosRepository;
        this.opinionesRepository = opinionesRepository;
    }

    /**
     * Buscar todas las categorías en Base de Datos
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/api/categorias")
    public List<Categorias> findAll() {
        return categoriasRepository.findAll();
    }

    /**
     * Buscar categorías por  id
     * Request
     * Response
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/api/categorias/{id}")
    public List<TrabajosDto> findById(@PathVariable Long id) {
        Optional<Categorias> categoriaOpt = categoriasRepository.findById(id);
        if (categoriaOpt.isPresent()) {
            Set<Trabajos> trabajos1 = categoriaOpt.get().getTrabajos();

            List<Trabajos> trabajos = new ArrayList<>(trabajos1);





            List<Opiniones> opiniones = opinionesRepository.findAll();
            List<TrabajosDto> trabajosDto =new ArrayList<>();
            TrabajosDto trabajoDto = new TrabajosDto();
            for (int i=0; i<trabajos.size();i++) {
                    trabajoDto = new TrabajosDto(trabajos.get(i).getId(), trabajos.get(i).getNombre(), trabajos.get(i).getImage(),
                            trabajos.get(i).getDescripcion(), trabajos.get(i).getCategorias(), trabajos.get(i).getEmpleadores(),
                            trabajos.get(i).getFecha(), trabajos.get(i).getPais(), trabajos.get(i).getIdiomas(),
                            trabajos.get(i).getPrecio());
                    int sumaOpiniones = 0, cantOpiniones = 0;
                    double promedio = 0;
                    for (int j = 0; j < opiniones.size(); j++) {
                        if ((opiniones.get(j).getTrabajo()) == (trabajos.get(i))) {
                            cantOpiniones++;
                            sumaOpiniones = sumaOpiniones + opiniones.get(j).getCalificacion();
                        }
                    }
                    if (cantOpiniones > 0) {
                        trabajoDto.setOpiniones(cantOpiniones);
                        promedio = sumaOpiniones / cantOpiniones;
                        trabajoDto.setPromedio(promedio);
                    }
                    trabajosDto.add(trabajoDto);

                }
            return trabajosDto;

            }


           return null;
    }


    /**
     * Crear categoria nueva en la bbdd.
     *
     * @param categoria
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/api/categorias")
    public ResponseEntity<Categorias> create(@RequestBody Categorias categoria) {
        if (categoria.getId() != null) {
            log.warn("Intentando crear una categoría con id");
            return ResponseEntity.badRequest().build();
        }
        List<Categorias> categorias = categoriasRepository.findAll();
        for (Categorias categoriaEnRepo : categorias) {
            if (categoriaEnRepo.getNombre().equals(categoria.getNombre())) {
                log.warn("Intentando crear una categoria ya existente");
                return ResponseEntity.badRequest().build();
            }
        }

       Categorias result = categoriasRepository.save(categoria);
        return ResponseEntity.ok(result);
    }

    /**
     * Actualizar una tecnologia en la bbdd.
     *
     * @param categoria
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/api/categorias")
    public ResponseEntity<Categorias> update(@RequestBody Categorias categoria) {
        if (categoria.getId() == null) {
            log.warn("Intentando actualizar una categoria sin dar el id");
            return ResponseEntity.badRequest().build();
        }
        if (!categoriasRepository.existsById(categoria.getId())) {
            log.warn("Intentando actualizar una categoria con id inexistente");
            return ResponseEntity.notFound().build();
        }

        Categorias result = categoriasRepository.save(categoria);
        return ResponseEntity.ok(result);
    }

    /**
     * Eliminar una categoria de la bbdd.
     *
     * @param id
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/api/categorias/{id}")
    public ResponseEntity<Categorias> delete(@PathVariable Long id) {

        if (!categoriasRepository.existsById(id)) {
            log.warn("Intentando eliminar una categoria inexistente");
            return ResponseEntity.notFound().build();
        }

        Optional<Categorias> categoriaOpt = categoriasRepository.findById(id);
        if (categoriaOpt.isPresent()) {
            Categorias categoria = categoriaOpt.get();
            System.out.println(categoria );
            System.out.println(categoria.getTrabajos());
            Set<Trabajos> trabajos = categoria.getTrabajos();
            for (Trabajos trabajo : trabajos) {
                trabajo.removeCategoria(categoria, false);
                trabajosRepository.save(trabajo);
            }
        }

        categoriasRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Eliminar todas las categorias de la base de datos
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/api/categorias")
    public ResponseEntity<Categorias> deleteAll() {
        log.info("Petición REST para eliminar todas las categorias");
        List<Categorias> categorias = categoriasRepository.findAll();

        for (Categorias categoria: categorias) {
            Set<Trabajos> trabajos = categoria.getTrabajos();
            for (Trabajos trabajo: trabajos) {
                trabajo.removeCategoria(categoria, false);
                trabajosRepository.save(trabajo);
            }
        }

        categoriasRepository.deleteAll();

        return ResponseEntity.noContent().build();
    }
}