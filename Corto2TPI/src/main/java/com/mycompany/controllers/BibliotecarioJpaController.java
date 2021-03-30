/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.controllers.exceptions.NonexistentEntityException;
import com.mycompany.entity.Bibliotecario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author cmargueiz
 */
public class BibliotecarioJpaController implements Serializable {

    public BibliotecarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Bibliotecario bibliotecario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bibliotecario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bibliotecario bibliotecario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bibliotecario = em.merge(bibliotecario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = bibliotecario.getId();
                if (findBibliotecario(id) == null) {
                    throw new NonexistentEntityException("The bibliotecario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bibliotecario bibliotecario;
            try {
                bibliotecario = em.getReference(Bibliotecario.class, id);
                bibliotecario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bibliotecario with id " + id + " no longer exists.", enfe);
            }
            em.remove(bibliotecario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Bibliotecario findBibliotecario(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bibliotecario.class, id);
        } finally {
            em.close();
        }
    }

    public int getBibliotecarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Bibliotecario> rt = cq.from(Bibliotecario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
