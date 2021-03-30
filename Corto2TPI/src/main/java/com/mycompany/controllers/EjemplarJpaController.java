
package com.mycompany.controllers;

import com.mycompany.controllers.exceptions.IllegalOrphanException;
import com.mycompany.controllers.exceptions.NonexistentEntityException;
import com.mycompany.entity.Ejemplar;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.entity.Libro;
import com.mycompany.entity.Usuario;
import com.mycompany.entity.Historico;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author cmargueiz
 */
public class EjemplarJpaController implements Serializable {

    public EjemplarJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ejemplar ejemplar) {
        if (ejemplar.getHistoricoSet() == null) {
            ejemplar.setHistoricoSet(new HashSet<Historico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro libroId = ejemplar.getLibroId();
            if (libroId != null) {
                libroId = em.getReference(libroId.getClass(), libroId.getId());
                ejemplar.setLibroId(libroId);
            }
            Usuario usuarioId = ejemplar.getUsuarioId();
            if (usuarioId != null) {
                usuarioId = em.getReference(usuarioId.getClass(), usuarioId.getId());
                ejemplar.setUsuarioId(usuarioId);
            }
            Set<Historico> attachedHistoricoSet = new HashSet<Historico>();
            for (Historico historicoSetHistoricoToAttach : ejemplar.getHistoricoSet()) {
                historicoSetHistoricoToAttach = em.getReference(historicoSetHistoricoToAttach.getClass(), historicoSetHistoricoToAttach.getId());
                attachedHistoricoSet.add(historicoSetHistoricoToAttach);
            }
            ejemplar.setHistoricoSet(attachedHistoricoSet);
            em.persist(ejemplar);
            if (libroId != null) {
                libroId.getEjemplarSet().add(ejemplar);
                libroId = em.merge(libroId);
            }
            if (usuarioId != null) {
                usuarioId.getEjemplarSet().add(ejemplar);
                usuarioId = em.merge(usuarioId);
            }
            for (Historico historicoSetHistorico : ejemplar.getHistoricoSet()) {
                Ejemplar oldEjemplarIdOfHistoricoSetHistorico = historicoSetHistorico.getEjemplarId();
                historicoSetHistorico.setEjemplarId(ejemplar);
                historicoSetHistorico = em.merge(historicoSetHistorico);
                if (oldEjemplarIdOfHistoricoSetHistorico != null) {
                    oldEjemplarIdOfHistoricoSetHistorico.getHistoricoSet().remove(historicoSetHistorico);
                    oldEjemplarIdOfHistoricoSetHistorico = em.merge(oldEjemplarIdOfHistoricoSetHistorico);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ejemplar ejemplar) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ejemplar persistentEjemplar = em.find(Ejemplar.class, ejemplar.getId());
            Libro libroIdOld = persistentEjemplar.getLibroId();
            Libro libroIdNew = ejemplar.getLibroId();
            Usuario usuarioIdOld = persistentEjemplar.getUsuarioId();
            Usuario usuarioIdNew = ejemplar.getUsuarioId();
            Set<Historico> historicoSetOld = persistentEjemplar.getHistoricoSet();
            Set<Historico> historicoSetNew = ejemplar.getHistoricoSet();
            List<String> illegalOrphanMessages = null;
            for (Historico historicoSetOldHistorico : historicoSetOld) {
                if (!historicoSetNew.contains(historicoSetOldHistorico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Historico " + historicoSetOldHistorico + " since its ejemplarId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (libroIdNew != null) {
                libroIdNew = em.getReference(libroIdNew.getClass(), libroIdNew.getId());
                ejemplar.setLibroId(libroIdNew);
            }
            if (usuarioIdNew != null) {
                usuarioIdNew = em.getReference(usuarioIdNew.getClass(), usuarioIdNew.getId());
                ejemplar.setUsuarioId(usuarioIdNew);
            }
            Set<Historico> attachedHistoricoSetNew = new HashSet<Historico>();
            for (Historico historicoSetNewHistoricoToAttach : historicoSetNew) {
                historicoSetNewHistoricoToAttach = em.getReference(historicoSetNewHistoricoToAttach.getClass(), historicoSetNewHistoricoToAttach.getId());
                attachedHistoricoSetNew.add(historicoSetNewHistoricoToAttach);
            }
            historicoSetNew = attachedHistoricoSetNew;
            ejemplar.setHistoricoSet(historicoSetNew);
            ejemplar = em.merge(ejemplar);
            if (libroIdOld != null && !libroIdOld.equals(libroIdNew)) {
                libroIdOld.getEjemplarSet().remove(ejemplar);
                libroIdOld = em.merge(libroIdOld);
            }
            if (libroIdNew != null && !libroIdNew.equals(libroIdOld)) {
                libroIdNew.getEjemplarSet().add(ejemplar);
                libroIdNew = em.merge(libroIdNew);
            }
            if (usuarioIdOld != null && !usuarioIdOld.equals(usuarioIdNew)) {
                usuarioIdOld.getEjemplarSet().remove(ejemplar);
                usuarioIdOld = em.merge(usuarioIdOld);
            }
            if (usuarioIdNew != null && !usuarioIdNew.equals(usuarioIdOld)) {
                usuarioIdNew.getEjemplarSet().add(ejemplar);
                usuarioIdNew = em.merge(usuarioIdNew);
            }
            for (Historico historicoSetNewHistorico : historicoSetNew) {
                if (!historicoSetOld.contains(historicoSetNewHistorico)) {
                    Ejemplar oldEjemplarIdOfHistoricoSetNewHistorico = historicoSetNewHistorico.getEjemplarId();
                    historicoSetNewHistorico.setEjemplarId(ejemplar);
                    historicoSetNewHistorico = em.merge(historicoSetNewHistorico);
                    if (oldEjemplarIdOfHistoricoSetNewHistorico != null && !oldEjemplarIdOfHistoricoSetNewHistorico.equals(ejemplar)) {
                        oldEjemplarIdOfHistoricoSetNewHistorico.getHistoricoSet().remove(historicoSetNewHistorico);
                        oldEjemplarIdOfHistoricoSetNewHistorico = em.merge(oldEjemplarIdOfHistoricoSetNewHistorico);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
           
        
        } 
                finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ejemplar ejemplar;
            try {
                ejemplar = em.getReference(Ejemplar.class, id);
                ejemplar.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ejemplar with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Set<Historico> historicoSetOrphanCheck = ejemplar.getHistoricoSet();
            for (Historico historicoSetOrphanCheckHistorico : historicoSetOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ejemplar (" + ejemplar + ") cannot be destroyed since the Historico " + historicoSetOrphanCheckHistorico + " in its historicoSet field has a non-nullable ejemplarId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Libro libroId = ejemplar.getLibroId();
            if (libroId != null) {
                libroId.getEjemplarSet().remove(ejemplar);
                libroId = em.merge(libroId);
            }
            Usuario usuarioId = ejemplar.getUsuarioId();
            if (usuarioId != null) {
                usuarioId.getEjemplarSet().remove(ejemplar);
                usuarioId = em.merge(usuarioId);
            }
            em.remove(ejemplar);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ejemplar> findEjemplarEntities() {
        return findEjemplarEntities(true, -1, -1);
    }

    public List<Ejemplar> findEjemplarEntities(int maxResults, int firstResult) {
        return findEjemplarEntities(false, maxResults, firstResult);
    }

    private List<Ejemplar> findEjemplarEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ejemplar.class));
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

    public Ejemplar findEjemplar(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ejemplar.class, id);
        } finally {
            em.close();
        }
    }

    public int getEjemplarCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ejemplar> rt = cq.from(Ejemplar.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
