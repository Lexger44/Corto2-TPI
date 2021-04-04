/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.entity.Ejemplar;
import com.mycompany.entity.Historico;
import com.mycompany.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author cmargueiz
 */
public class HistoricoJpaController implements Serializable {

    private EntityManagerFactory emf = null;
    
    public HistoricoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Historico historico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ejemplar ejemplarId = historico.getEjemplarId();
            if (ejemplarId != null) {
                ejemplarId = em.getReference(ejemplarId.getClass(), ejemplarId.getId());
                historico.setEjemplarId(ejemplarId);
            }
            Usuario usuarioId = historico.getUsuarioId();
            if (usuarioId != null) {
                usuarioId = em.getReference(usuarioId.getClass(), usuarioId.getId());
                historico.setUsuarioId(usuarioId);
            }
            em.persist(historico);

            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Historico historico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            historico = em.merge(historico);
            em.getTransaction().commit();
        } catch (Exception ex) {

            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Historico historico) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(historico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }



    
    
}
