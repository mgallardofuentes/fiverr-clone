package com.example.Equipo3ProyectoFiverr.entities;


import com.example.Equipo3ProyectoFiverr.Paises;
import com.example.Equipo3ProyectoFiverr.TipoEmpresa;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "empleadores")
public class Empleadores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @Enumerated//(EnumType.ORDINAL)
    private TipoEmpresa tipo;

    @Enumerated//(EnumType.ORDINAL)
    private Paises pais;

    private String image;

    @ManyToMany(mappedBy = "empleadores", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Trabajos> trabajos= new HashSet<>();


    public Empleadores() {
    }

    public Empleadores(Long id, String nombre, String descripcion, TipoEmpresa tipo, Paises pais) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.pais = pais;
    }

    public Empleadores(Long id, String nombre, String descripcion, TipoEmpresa tipo, Paises pais, String image,
                       Set<Trabajos> trabajos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.pais = pais;
        this.image = image;
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

    public TipoEmpresa getTipo() {
        return tipo;
    }

    public void setTipo(TipoEmpresa tipo) {
        this.tipo = tipo;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

    public Set<Trabajos> getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(Set<Trabajos> trabajos) {
        this.trabajos = trabajos;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}



