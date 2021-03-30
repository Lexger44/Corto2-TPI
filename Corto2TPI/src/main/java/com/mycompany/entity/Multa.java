/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "multa", catalog = "biblioteca", schema = "")
@NamedQueries({
    @NamedQuery(name = "Multa.findAll", query = "SELECT m FROM Multa m"),
    @NamedQuery(name = "Multa.findById", query = "SELECT m FROM Multa m WHERE m.id = :id"),
    @NamedQuery(name = "Multa.findByEstado", query = "SELECT m FROM Multa m WHERE m.estado = :estado"),
    @NamedQuery(name = "Multa.findByFechaFin", query = "SELECT m FROM Multa m WHERE m.fechaFin = :fechaFin"),
    @NamedQuery(name = "Multa.findByFechaInicio", query = "SELECT m FROM Multa m WHERE m.fechaInicio = :fechaInicio")})
public class Multa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 9)
    private String estado;
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioId;

    public Multa() {
    }

    public Multa(Long id) {
        this.id = id;
    }

    public Multa(Long id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Multa[ id=" + id + " ]";
    }
    
}
