package com.example.Equipo3ProyectoFiverr.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categorias")
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Resto de atributos
    private String nombre;
    private String descripcion;

    //@OneToMany
    //private Set<Trabajos> trabajos = new HashSet<>();

    @ManyToMany(mappedBy = "categorias", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Trabajos> trabajos= new HashSet<>();

    public Categorias() {

    }


    public Categorias(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Categorias(Long id, String nombre, String descripcion, Set<Trabajos> trabajos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.trabajos = trabajos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Trabajos> getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(Set<Trabajos> trabajos) {
        this.trabajos = trabajos;
    }
}
