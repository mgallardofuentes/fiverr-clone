package com.example.Equipo3ProyectoFiverr.repositories;


import com.example.Equipo3ProyectoFiverr.entities.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Interfaz que permite ejecutar consultas para la entidad Oferta
 * a través de JPA en la base de datos.
 */
@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
}
