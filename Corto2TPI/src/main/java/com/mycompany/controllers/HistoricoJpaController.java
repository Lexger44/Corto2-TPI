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

    public HistoricoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

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
            if (ejemplarId != null) {
                ejemplarId.getHistoricoSet().add(historico);
                ejemplarId = em.merge(ejemplarId);
            }
            if (usuarioId != null) {
                usuarioId.getHistoricoSet().add(historico);
                usuarioId = em.merge(usuarioId);
            }
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
            Historico persistentHistorico = em.find(Historico.class, historico.getId());
            Ejemplar ejemplarIdOld = persistentHistorico.getEjemplarId();
            Ejemplar ejemplarIdNew = historico.getEjemplarId();
            Usuario usuarioIdOld = persistentHistorico.getUsuarioId();
            Usuario usuarioIdNew = historico.getUsuarioId();
            if (ejemplarIdNew != null) {
                ejemplarIdNew = em.getReference(ejemplarIdNew.getClass(), ejemplarIdNew.getId());
                historico.setEjemplarId(ejemplarIdNew);
            }
            if (usuarioIdNew != null) {
                usuarioIdNew = em.getReference(usuarioIdNew.getClass(), usuarioIdNew.getId());
                historico.setUsuarioId(usuarioIdNew);
            }
            historico = em.merge(historico);
            if (ejemplarIdOld != null && !ejemplarIdOld.equals(ejemplarIdNew)) {
                ejemplarIdOld.getHistoricoSet().remove(historico);
                ejemplarIdOld = em.merge(ejemplarIdOld);
            }
            if (ejemplarIdNew != null && !ejemplarIdNew.equals(ejemplarIdOld)) {
                ejemplarIdNew.getHistoricoSet().add(historico);
                ejemplarIdNew = em.merge(ejemplarIdNew);
            }
            if (usuarioIdOld != null && !usuarioIdOld.equals(usuarioIdNew)) {
                usuarioIdOld.getHistoricoSet().remove(historico);
                usuarioIdOld = em.merge(usuarioIdOld);
            }
            if (usuarioIdNew != null && !usuarioIdNew.equals(usuarioIdOld)) {
                usuarioIdNew.getHistoricoSet().add(historico);
                usuarioIdNew = em.merge(usuarioIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = historico.getId();
                if (findHistorico(id) == null) {
                    throw new NonexistentEntityException("The historico with id " + id + " no longer exists.");
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
            Historico historico;
            try {
                historico = em.getReference(Historico.class, id);
                historico.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historico with id " + id + " no longer exists.", enfe);
            }
            Ejemplar ejemplarId = historico.getEjemplarId();
            if (ejemplarId != null) {
                ejemplarId.getHistoricoSet().remove(historico);
                ejemplarId = em.merge(ejemplarId);
            }
            Usuario usuarioId = historico.getUsuarioId();
            if (usuarioId != null) {
                usuarioId.getHistoricoSet().remove(historico);
                usuarioId = em.merge(usuarioId);
            }
            em.remove(historico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Historico> findHistoricoEntities() {
        return findHistoricoEntities(true, -1, -1);
    }

    public List<Historico> findHistoricoEntities(int maxResults, int firstResult) {
        return findHistoricoEntities(false, maxResults, firstResult);
    }

    private List<Historico> findHistoricoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Historico.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Historico findHistorico(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Historico.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistoricoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Historico> rt = cq.from(Historico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
