package com.example.Equipo3ProyectoFiverr.entities;


import javax.persistence.*;

@Entity
@Table(name = "opiniones")
public class Opiniones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //todo limitarlo a cinco

    @Column()
    private int calificacion;

    private String descripcion;

    @ManyToOne
    private Trabajos trabajo;

    @ManyToOne
    private Empleadores empleador;

    public Opiniones() {
    }

    public Opiniones(Long id, int calificacion, String descripcion, Trabajos trabajo, Empleadores empleador) {
        this.id = id;
        this.calificacion = calificacion;
        this.descripcion = descripcion;
        this.trabajo = trabajo;
        this.empleador = empleador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Trabajos getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Trabajos trabajo) {
        this.trabajo = trabajo;
    }

    public Empleadores getEmpleador() {
        return empleador;
    }

    public void setEmpleador(Empleadores empleador) {
        this.empleador = empleador;
    }
}
