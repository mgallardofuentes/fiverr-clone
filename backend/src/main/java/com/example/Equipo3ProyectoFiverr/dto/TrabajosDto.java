package com.example.Equipo3ProyectoFiverr.dto;

import com.example.Equipo3ProyectoFiverr.Idiomas;
import com.example.Equipo3ProyectoFiverr.Paises;
import com.example.Equipo3ProyectoFiverr.entities.Categorias;
import com.example.Equipo3ProyectoFiverr.entities.Empleadores;

import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class TrabajosDto {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String image;
    private String descripcion;
    private Integer opiniones;
    private Double promedio;
    private Double precio;
    private Set<Categorias> categorias = new HashSet<>();
    private Set<Empleadores> empleadores = new HashSet<>();
    private LocalDate fecha;

    public TrabajosDto() {
    }

    public TrabajosDto(Long id, String nombre, String image, String descripcion, Set<Categorias> categorias,
                       Set<Empleadores> empleadores, LocalDate fecha, Paises pais, Idiomas idiomas, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.image = image;
        this.descripcion = descripcion;
        this.categorias = categorias;
        this.empleadores = empleadores;
        this.fecha = fecha;
        this.pais = pais;
        this.idiomas = idiomas;
        this.precio=precio;
    }

    @Enumerated//(EnumType.ORDINAL)
    private Paises pais;

    @Enumerated//(EnumType.ORDINAL)
    private Idiomas idiomas;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getOpiniones() {
        return opiniones;
    }

    public void setOpiniones(Integer opiniones) {
        this.opiniones = opiniones;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public Set<Categorias> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categorias> categorias) {
        this.categorias = categorias;
    }

    public Set<Empleadores> getEmpleadores() {
        return empleadores;
    }

    public void setEmpleadores(Set<Empleadores> empleadores) {
        this.empleadores = empleadores;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

    public Idiomas getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(Idiomas idiomas) {
        this.idiomas = idiomas;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
