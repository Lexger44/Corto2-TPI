/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.entity.Reserva;
import com.mycompany.controllers.exceptions.NonexistentEntityException;
import com.mycompany.entity.Libro;
import com.mycompany.entity.Usuario;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.TypedQuery;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author sofia
 */
@ExtendWith(MockitoExtension.class)
public class ReservaJpaControllerTest {
    
   
    public ReservaJpaControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
      
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getEntityManager method, of class ReservaJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        EntityManagerFactory mockEMF = Mockito.mock(EntityManagerFactory.class);
        ReservaJpaController instance = new ReservaJpaController(mockEMF);
        EntityManager expResult = Mockito.mock(EntityManager.class);
        Mockito.when(instance.getEntityManager()).thenReturn(expResult);
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
    }

    /**
     * Test of create method, of class ReservaJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Reserva reserva = new Reserva();
        EntityManagerFactory mockEMF = Mockito.mock(EntityManagerFactory.class);
        EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
        ReservaJpaController instance = new ReservaJpaController(mockEMF);
        Mockito.when(instance.getEntityManager()).thenReturn(mockEM);
        reserva.setUsuarioId(new Usuario(1L));
        Usuario mockUsuario = Mockito.mock(Usuario.class);
        Mockito.when(mockEM.getReference(Usuario.class, 1L)).thenReturn(mockUsuario);
//        reserva.setLibroId(new Libro(1));
//        Libro mockLibro = Mockito.mock(Libro.class);
//        Mockito.when(mockEM.getReference(Libro.class, 1)).thenReturn(mockLibro);
        instance.create(reserva);
    }

    /**
     * Test of edit method, of class ReservaJpaController.
     */
    @Test
    public void testEdit() throws Exception, NonexistentEntityException {
        System.out.println("edit");
        Reserva reserva = null;
        ReservaJpaController instance = null;
//        instance.edit(reserva);
   
    }

    /**
     * Test of destroy method, of class ReservaJpaController.
     */
    @Test
    public void testDestroy() throws Exception, NonexistentEntityException {
        System.out.println("destroy");
        Reserva mockReserva = Mockito.mock(Reserva.class);
        Long id = mockReserva.getId();
        mockReserva.setId(id);
        EntityManagerFactory mockEMF = Mockito.mock(EntityManagerFactory.class);
        ReservaJpaController instance = new ReservaJpaController(mockEMF);
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
        Mockito.when(instance.getEntityManager()).thenReturn(mockEM);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
        Mockito.when(mockEM.getReference(Reserva.class, mockReserva.getId())).thenReturn(mockReserva);
        Usuario mockUsuario = Mockito.mock(Usuario.class);
        Mockito.when(mockReserva.getUsuarioId()).thenReturn(mockUsuario);
        Set<Reserva> mockReservaSet = Mockito.mock(Set.class);
        Libro mockLibro = Mockito.mock(Libro.class);
        Mockito.when(mockReserva.getLibroId()).thenReturn(mockLibro);
//        Set<Reserva> mockReservaSet = Mockito.mock(Set.class
        instance.destroy(id);
    }

    /**
     * Test of findReservaEntities method, of class ReservaJpaController.
     */
    @Test
    public void testFindReservaEntities_0args() {
        System.out.println("findReservaEntities");
        ReservaJpaController instance = null;
        List<Reserva> expResult = null;
//        List<Reserva> result = instance.findReservaEntities();
//        assertEquals(expResult, result);
//  
    }

    /**
     * Test of findReservaEntities method, of class ReservaJpaController.
     */
    @Test
    public void testFindReservaEntities_int_int() {
        System.out.println("findReservaEntities");
        Reserva mockReserva = Mockito.mock(Reserva.class);
        Long id = mockReserva.getId();
        mockReserva.setId(id);
        EntityManagerFactory mockEMF = Mockito.mock(EntityManagerFactory.class);
        ReservaJpaController instance = new ReservaJpaController(mockEMF);
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        Mockito.when(instance.getEntityManager()).thenReturn(mockEM);
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);   
        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery()).thenReturn(mockCQ);
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
        Mockito.when(mockEM.createQuery(mockCQ)).thenReturn(mockTQ);       
        
        List<Reserva> mockList = Mockito.mock(List.class);
        mockTQ.setMaxResults(mockList.size());
        mockTQ.setFirstResult(0);
        int maxResults = mockList.size();
        int firstResult = 0;
        List <Reserva> expResult = mockTQ.getResultList();
        List<Reserva> result = instance.findReservaEntities(maxResults, firstResult);
        assertEquals(expResult, result);
    }

    /**
     * Test of findReserva method, of class ReservaJpaController.
     */
    @Test
    public void testFindReserva() {
        System.out.println("findReserva");
        Long id = null;
        ReservaJpaController instance = null;
        Reserva expResult = null;
//        Reserva result = instance.findReserva(id);
//        assertEquals(expResult, result);
//        
    }

    /**
     * Test of getReservaCount method, of class ReservaJpaController.
     */
    @Test
    public void testGetReservaCount() {
        System.out.println("getReservaCount");
        ReservaJpaController instance = null;
        int expResult = 0;
//        int result = instance.getReservaCount();
//        assertEquals(expResult, result);
//   
    }  
}
