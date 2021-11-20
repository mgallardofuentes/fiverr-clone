package com.example.Equipo3ProyectoFiverr.controller;


import com.example.Equipo3ProyectoFiverr.dto.TrabajosDto;
import com.example.Equipo3ProyectoFiverr.entities.Categorias;
import com.example.Equipo3ProyectoFiverr.entities.Empleadores;
import com.example.Equipo3ProyectoFiverr.entities.Opiniones;
import com.example.Equipo3ProyectoFiverr.entities.Trabajos;
import com.example.Equipo3ProyectoFiverr.repositories.CategoriasRepository;
import com.example.Equipo3ProyectoFiverr.repositories.EmpleadoresRepository;
import com.example.Equipo3ProyectoFiverr.repositories.OpinionesRepository;
import com.example.Equipo3ProyectoFiverr.repositories.TrabajosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TrabajosController {

    private final Logger log = LoggerFactory.getLogger(TrabajosController.class);

    private TrabajosRepository trabajosRepository;
    private CategoriasRepository categoriasRepository;
    private EmpleadoresRepository empleadoresRepository;
    private OpinionesRepository opinionesRepository;

    public TrabajosController(TrabajosRepository trabajosRepository, CategoriasRepository categoriasRepository,
                              EmpleadoresRepository empleadoresRepository, OpinionesRepository opinionesRepository) {
        this.trabajosRepository = trabajosRepository;
        this.categoriasRepository = categoriasRepository;
        this.empleadoresRepository = empleadoresRepository;
        this.opinionesRepository = opinionesRepository;
    }

    /**
     * Buscar todas los trabajos en base de datos
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/api/trabajostodos")
    public List<Trabajos> findAll() {
        return trabajosRepository.findAll();
    }

    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/api/trabajos")
    public List<TrabajosDto> findAllT() {

        List<Trabajos> trabajos = trabajosRepository.findAll();
        List<Opiniones> opiniones = opinionesRepository.findAll();
        List<TrabajosDto> trabajosDto =new ArrayList<TrabajosDto>();
        TrabajosDto trabajoDto = new TrabajosDto();

        for(int i=0; i<trabajos.size();i++){
            trabajoDto = new TrabajosDto(trabajos.get(i).getId(),trabajos.get(i).getNombre(),trabajos.get(i).getImage(),
                    trabajos.get(i).getDescripcion(), trabajos.get(i).getCategorias(),trabajos.get(i).getEmpleadores(),
                    trabajos.get(i).getFecha(),trabajos.get(i).getPais(),trabajos.get(i).getIdiomas(),
                    trabajos.get(i).getPrecio());

            int sumaOpiniones=0, cantOpiniones=0;
            double promedio=0;
            for (int j=0;j<opiniones.size();j++){
                if ((opiniones.get(j).getTrabajo())==(trabajos.get(i))){
                    cantOpiniones++;
                    sumaOpiniones=sumaOpiniones+opiniones.get(j).getCalificacion();
                }
            }
            if (cantOpiniones>0){
                trabajoDto.setOpiniones(cantOpiniones);
                promedio = sumaOpiniones/cantOpiniones;
                trabajoDto.setPromedio(promedio);
            }
            trabajosDto.add(trabajoDto);

        }


        return trabajosDto;
    }
    /**
     * Buscar trabajos según id con json adaptado
     * Request
     * Response
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/api/trabajos/{id}")
    public ResponseEntity<TrabajosDto> findByIdAdaptado(@PathVariable Long id) {
        Optional<Trabajos> trabajosOpt = trabajosRepository.findById(id);
        if (trabajosOpt.isPresent()){
            List<Opiniones> opiniones = opinionesRepository.findAll();
            TrabajosDto trabajoDto;

            trabajoDto = new TrabajosDto(trabajosOpt.get().getId(),trabajosOpt.get().getNombre(),trabajosOpt.get().getImage(),
                    trabajosOpt.get().getDescripcion(), trabajosOpt.get().getCategorias(),trabajosOpt.get().getEmpleadores(),
                    trabajosOpt.get().getFecha(),trabajosOpt.get().getPais(),trabajosOpt.get().getIdiomas(),
                    trabajosOpt.get().getPrecio());

            int sumaOpiniones=0, cantOpiniones=0;
            double promedio=0;
            for (int j=0;j<opiniones.size();j++){
                if ((opiniones.get(j).getTrabajo())==(trabajosOpt.get())){
                    cantOpiniones++;
                    sumaOpiniones=sumaOpiniones+opiniones.get(j).getCalificacion();
                }
            }
            if (cantOpiniones>0){
                trabajoDto.setOpiniones(cantOpiniones);
                promedio = sumaOpiniones/cantOpiniones;
                trabajoDto.setPromedio(promedio);
            }
            return ResponseEntity.ok(trabajoDto);

        }

        else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Buscar trabajos según id
     * Request
     * Response
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/api/trabajostodos/{id}")
    public ResponseEntity<Trabajos> findById(@PathVariable Long id) {
        Optional<Trabajos> trabajosOpt = trabajosRepository.findById(id);


        if (trabajosOpt.isPresent()) {
            return ResponseEntity.ok(trabajosOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crear un nuevo trabajo en la base de datos
     *
     * @param trabajo
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/api/trabajos")
    public ResponseEntity<Trabajos> create(@RequestBody Trabajos trabajo) {
        if(trabajo.getId() != null) {
            log.warn("Intentando crear un trabajo con id");
            return ResponseEntity.badRequest().build();
        }

        Set<Categorias> categorias = trabajo.getCategorias();

        for (Categorias categoria: categorias) {
            if(categoria.getId() == null) {
                log.info("Creando categoria inexistente: " + categoria.getNombre());
                categoriasRepository.save(categoria);
            }
        }

        Set<Empleadores> empleadores = trabajo.getEmpleadores();

        for (Empleadores empleador: empleadores) {
            if(empleador.getId() == null) {
                log.info("Creando empleador inexistente: " + empleador.getNombre());
                empleadoresRepository.save(empleador);
            }
        }

       Trabajos trabajoAGuardar = new Trabajos(

               null,
               trabajo.getNombre(),
               trabajo.getDescripcion(),
               trabajo.getImage(),
               trabajo.getPrecio(),
               trabajo.getVerificado(),
               trabajo.getFecha(),
               trabajo.getPais(),
               trabajo.getIdiomas()

        );

        for (Empleadores empleador: trabajo.getEmpleadores()) {
            trabajoAGuardar.addEmpleador(empleador);
        }
        for (Categorias categoria: trabajo.getCategorias()) {
            trabajoAGuardar.addCategoria(categoria);
        }

        Trabajos result = trabajosRepository.save(trabajoAGuardar);
        return ResponseEntity.ok(result);
    }

    /**
     * Actualizar una trabjo en base de datos.
     *
     * @param trabajo
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/api/trabajos")
    public ResponseEntity<Trabajos> update(@RequestBody Trabajos trabajo) {
        if (trabajo.getId() == null) {
            log.warn("Intentando actualizar un trabajo inexistente");
            return ResponseEntity.badRequest().build();
        }
        if (!trabajosRepository.existsById(trabajo.getId())) {
            log.warn("Intentando actualizar un trabajo inexistente");
            return ResponseEntity.notFound().build();
        }

        Set<Categorias> categorias = trabajo.getCategorias();

        for (Categorias categoria: categorias) {
            if(categoria.getId() == null) {
                log.info("Creando categoria inexistente: " + categoria.getNombre());
                categoriasRepository.save(categoria);
            }
        }

        Set<Empleadores> empleadores = trabajo.getEmpleadores();

        for (Empleadores empleador: empleadores) {
            if(empleador.getId() == null) {
                log.info("Creando empleador inexistente: " + empleador.getNombre());
                empleadoresRepository.save(empleador);
            }
        }


        Optional<Trabajos> trabajoOpt = trabajosRepository.findById(trabajo.getId());
        if (trabajoOpt.isPresent()) {
            Trabajos trabajoAntiguo = trabajoOpt.get();
            desvincularCategorias(trabajoAntiguo);
            desvincularEmpleadores(trabajoAntiguo);
        }

        Trabajos trabajoAGuardar = new Trabajos(

                trabajo.getId(),
                trabajo.getNombre(),
                trabajo.getDescripcion(),
                trabajo.getImage(),
                trabajo.getPrecio(),
                trabajo.getVerificado(),
                trabajo.getFecha(),
                trabajo.getPais(),
                trabajo.getIdiomas()

        );

        for (Empleadores empleador: trabajo.getEmpleadores()) {
            trabajoAGuardar.addEmpleador(empleador);
        }
        for (Categorias categoria: trabajo.getCategorias()) {
            trabajoAGuardar.addCategoria(categoria);
        }

        Trabajos result = trabajosRepository.save(trabajoAGuardar);
        log.info("Actualizando trabajo: " + trabajoAGuardar.getId());
        return ResponseEntity.ok(result);
    }

    /**
     * Eliminar un trabajo en la base de datos
     * @param id
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/api/trabajos/{id}")
    public ResponseEntity<Trabajos> delete(@PathVariable Long id) {

        if (!trabajosRepository.existsById(id)) {
            log.warn("Intentando eliminar un trabajo inexistente");
            return ResponseEntity.notFound().build();
        }

        Optional<Trabajos> trabajoOpt = trabajosRepository.findById(id);
        if (trabajoOpt.isPresent()) {
            Trabajos trabajoAnterior = trabajoOpt.get();
            desvincularCategorias(trabajoAnterior);
            desvincularEmpleadores(trabajoAnterior);
        }

        trabajosRepository.deleteById(id);
        log.info("Eliminando trabajo: " + id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Eliminar todos los trabajos de la base de datos.
     *
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/api/trabajos")
    public ResponseEntity<Trabajos> deleteAll() {

        List<Trabajos> trabajos = trabajosRepository.findAll();
        for (Trabajos trabajo : trabajos) {
            desvincularCategorias(trabajo);
            desvincularEmpleadores(trabajo);

        }

        List<Categorias> categorias = categoriasRepository.findAll();
        List<Empleadores> empleadores = empleadoresRepository.findAll();

        empleadoresRepository.deleteAll();
        log.info("Eliminando todos los trabajos");
        return ResponseEntity.noContent().build();
    }

    /**
     * Método que desvincula cada trabajo de ls categorias que están ligadas a ellos.
     *
     * @param trabajo
     */
    private void desvincularCategorias(Trabajos trabajo) {
        Set<Categorias> categoriasABorrar = new HashSet<>(trabajo.getCategorias());
        for (Categorias categoria : categoriasABorrar) {
            trabajo.removeCategoria(categoria, true);
        }
    }

    /**
     * Método que desvincula cada trabajo de los empleadores están ligadas a ellos.
     *
     * @param trabajo
     */
    private void desvincularEmpleadores(Trabajos trabajo) {
        Set<Empleadores> empleadoresABorrar = new HashSet<>(trabajo.getEmpleadores());
        for (Empleadores empleador: empleadoresABorrar) {
            trabajo.removeEmpleador(empleador, true);
        }
    }


}
