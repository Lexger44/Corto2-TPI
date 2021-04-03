
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
    public EntityManagerFactory emf = null;

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
          
            em.persist(ejemplar);
           
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

            ejemplar = em.merge(ejemplar);
            
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

    public List<Ejemplar> EjemplarEntities() {
        return findEjemplarEntities();
    }



    private List<Ejemplar> findEjemplarEntities() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ejemplar.class));
            Query q = em.createQuery(cq);

            return q.getResultList();
        } finally {
            em.close();
        }
    }

    List<Ejemplar> findEjemplarEntities(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}
