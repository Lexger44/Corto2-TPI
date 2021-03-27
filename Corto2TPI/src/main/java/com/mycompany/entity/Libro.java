/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "libro", catalog = "biblioteca", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"isbn"})})
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findById", query = "SELECT l FROM Libro l WHERE l.id = :id"),
    @NamedQuery(name = "Libro.findByAutor", query = "SELECT l FROM Libro l WHERE l.autor = :autor"),
    @NamedQuery(name = "Libro.findByFechaAlta", query = "SELECT l FROM Libro l WHERE l.fechaAlta = :fechaAlta"),
    @NamedQuery(name = "Libro.findByIsbn", query = "SELECT l FROM Libro l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Libro.findByNumDisponibles", query = "SELECT l FROM Libro l WHERE l.numDisponibles = :numDisponibles"),
    @NamedQuery(name = "Libro.findByNumPaginas", query = "SELECT l FROM Libro l WHERE l.numPaginas = :numPaginas"),
    @NamedQuery(name = "Libro.findByTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "autor", length = 255)
    private String autor;
    @Column(name = "fechaAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Column(name = "isbn", length = 255)
    private String isbn;
    @Column(name = "numDisponibles")
    private Integer numDisponibles;
    @Column(name = "numPaginas")
    private Integer numPaginas;
    @Column(name = "titulo", length = 255)
    private String titulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libroId", fetch = FetchType.LAZY)
    private Set<Ejemplar> ejemplarSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libroId", fetch = FetchType.LAZY)
    private Set<Reserva> reservaSet;

    public Libro() {
    }

    public Libro(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNumDisponibles() {
        return numDisponibles;
    }

    public void setNumDisponibles(Integer numDisponibles) {
        this.numDisponibles = numDisponibles;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Set<Ejemplar> getEjemplarSet() {
        return ejemplarSet;
    }

    public void setEjemplarSet(Set<Ejemplar> ejemplarSet) {
        this.ejemplarSet = ejemplarSet;
    }

    public Set<Reserva> getReservaSet() {
        return reservaSet;
    }

    public void setReservaSet(Set<Reserva> reservaSet) {
        this.reservaSet = reservaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Libro[ id=" + id + " ]";
    }
    
}
