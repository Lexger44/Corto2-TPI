/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "usuario", catalog = "biblioteca", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email"}),
    @UniqueConstraint(columnNames = {"login"})})
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByTipo", query = "SELECT u FROM Usuario u WHERE u.tipo = :tipo"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByApellido1", query = "SELECT u FROM Usuario u WHERE u.apellido1 = :apellido1"),
    @NamedQuery(name = "Usuario.findByApellido2", query = "SELECT u FROM Usuario u WHERE u.apellido2 = :apellido2"),
    @NamedQuery(name = "Usuario.findByCalle", query = "SELECT u FROM Usuario u WHERE u.calle = :calle"),
    @NamedQuery(name = "Usuario.findByCiudad", query = "SELECT u FROM Usuario u WHERE u.ciudad = :ciudad"),
    @NamedQuery(name = "Usuario.findByCodigoPostal", query = "SELECT u FROM Usuario u WHERE u.codigoPostal = :codigoPostal"),
    @NamedQuery(name = "Usuario.findByNumero", query = "SELECT u FROM Usuario u WHERE u.numero = :numero"),
    @NamedQuery(name = "Usuario.findByPiso", query = "SELECT u FROM Usuario u WHERE u.piso = :piso"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado"),
    @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
    @NamedQuery(name = "Usuario.findByTutor", query = "SELECT u FROM Usuario u WHERE u.tutor = :tutor"),
    @NamedQuery(name = "Usuario.findByDepartamento", query = "SELECT u FROM Usuario u WHERE u.departamento = :departamento")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "tipo", nullable = false, length = 31)
    private String tipo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "apellido1", length = 255)
    private String apellido1;
    @Column(name = "apellido2", length = 255)
    private String apellido2;
    @Column(name = "calle", length = 255)
    private String calle;
    @Column(name = "ciudad", length = 255)
    private String ciudad;
    @Column(name = "codigoPostal", length = 255)
    private String codigoPostal;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "piso", length = 255)
    private String piso;
    @Column(name = "email", length = 255)
    private String email;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 7)
    private String estado;
    @Column(name = "login", length = 255)
    private String login;
    @Column(name = "nombre", length = 255)
    private String nombre;
    @Column(name = "password", length = 255)
    private String password;
    @Column(name = "tutor", length = 255)
    private String tutor;
    @Column(name = "departamento", length = 255)
    private String departamento;
    @OneToMany(mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private Set<Ejemplar> ejemplarSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private Set<Multa> multaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private Set<Historico> historicoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private Set<Reserva> reservaSet;

    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(Long id, String tipo, String estado) {
        this.id = id;
        this.tipo = tipo;
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Set<Ejemplar> getEjemplarSet() {
        return ejemplarSet;
    }

    public void setEjemplarSet(Set<Ejemplar> ejemplarSet) {
        this.ejemplarSet = ejemplarSet;
    }

    public Set<Multa> getMultaSet() {
        return multaSet;
    }

    public void setMultaSet(Set<Multa> multaSet) {
        this.multaSet = multaSet;
    }

    public Set<Historico> getHistoricoSet() {
        return historicoSet;
    }

    public void setHistoricoSet(Set<Historico> historicoSet) {
        this.historicoSet = historicoSet;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Usuario[ id=" + id + " ]";
    }
    
}
