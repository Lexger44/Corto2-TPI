/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "bibliotecario", catalog = "biblioteca", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"login"})})
@NamedQueries({
    @NamedQuery(name = "Bibliotecario.findAll", query = "SELECT b FROM Bibliotecario b"),
    @NamedQuery(name = "Bibliotecario.findById", query = "SELECT b FROM Bibliotecario b WHERE b.id = :id"),
    @NamedQuery(name = "Bibliotecario.findByEmail", query = "SELECT b FROM Bibliotecario b WHERE b.email = :email"),
    @NamedQuery(name = "Bibliotecario.findByLogin", query = "SELECT b FROM Bibliotecario b WHERE b.login = :login"),
    @NamedQuery(name = "Bibliotecario.findByNif", query = "SELECT b FROM Bibliotecario b WHERE b.nif = :nif"),
    @NamedQuery(name = "Bibliotecario.findByPassword", query = "SELECT b FROM Bibliotecario b WHERE b.password = :password")})
public class Bibliotecario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "login", length = 255)
    private String login;
    @Column(name = "nif", length = 255)
    private String nif;
    @Column(name = "password", length = 255)
    private String password;

    public Bibliotecario() {
    }

    public Bibliotecario(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Bibliotecario)) {
            return false;
        }
        Bibliotecario other = (Bibliotecario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.Bibliotecario[ id=" + id + " ]";
    }
    
}
