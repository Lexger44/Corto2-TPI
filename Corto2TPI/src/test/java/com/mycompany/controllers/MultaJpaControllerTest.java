/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.controllers.exceptions.NonexistentEntityException;
import com.mycompany.entity.Multa;
import com.mycompany.entity.Usuario;
import java.util.List;
import java.util.Set;
import javax.enterprise.inject.Any;
import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;

/**
 *
 * @author melvin
 */
@ExtendWith(MockitoExtension.class)
public class MultaJpaControllerTest {
    
    public MultaJpaControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getEntityManager method, of class MultaJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        EntityManagerFactory mockEMF = Mockito.mock(EntityManagerFactory.class);
        MultaJpaController instance = new MultaJpaController(mockEMF);
        EntityManager expResult = Mockito.mock(EntityManager.class);
        Mockito.when(instance.getEntityManager()).thenReturn(expResult);
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of create method, of class MultaJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Multa multa = new Multa();
        EntityManagerFactory mockEMF = Mockito.mock(EntityManagerFactory.class);
        MultaJpaController instance = new MultaJpaController(mockEMF);
        EntityManager em = null;
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
        Mockito.when(instance.getEntityManager()).thenReturn(mockEM);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
        
        multa.setUsuarioId(new Usuario(1L));
        Usuario mockUsuario = Mockito.mock(Usuario.class);
        Mockito.when(mockEM.getReference(Usuario.class, 1L)).thenReturn(mockUsuario);
        
        instance.create(multa);
        

    }

    /**
     * Test of edit method, of class MultaJpaController.
     */
    @Test
    public void testEdit() throws NonexistentEntityException, Exception {
        System.out.println("edit");
        Multa mockMulta = Mockito.mock(Multa.class);
        EntityManagerFactory mockEMF = Mockito.mock(EntityManagerFactory.class);
        MultaJpaController instance = new MultaJpaController(mockEMF);
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
        Mockito.when(instance.getEntityManager()).thenReturn(mockEM);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
        
        Mockito.when(mockEM.find(Multa.class, mockMulta.getId())).thenReturn(mockMulta);
      
               
        Usuario mockUsuario = Mockito.mock(Usuario.class);

        Mockito.when(mockMulta.getUsuarioId()).thenReturn(mockUsuario);
        Set<Multa> mockMultaSet = Mockito.mock(Set.class);
        mockUsuario.setMultaSet(mockMultaSet);
        instance.edit(mockMulta);

    }

    /**
     * Test of destroy method, of class MultaJpaController.
     */
    @Test
    public void testDestroy() throws NonexistentEntityException {
        System.out.println("destroy");
        Multa mockMulta = Mockito.mock(Multa.class);
        Long id = mockMulta.getId();
        mockMulta.setId(id);
        EntityManagerFactory mockEMF = Mockito.mock(EntityManagerFactory.class);
        MultaJpaController instance = new MultaJpaController(mockEMF);
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EntityTransaction mockTX = Mockito.mock(EntityTransaction.class);
        Mockito.when(instance.getEntityManager()).thenReturn(mockEM);
        Mockito.when(mockEM.getTransaction()).thenReturn(mockTX);
        Mockito.when(mockEM.getReference(Multa.class, mockMulta.getId())).thenReturn(mockMulta);
             
        Usuario mockUsuario = Mockito.mock(Usuario.class);
        Mockito.when(mockMulta.getUsuarioId()).thenReturn(mockUsuario);
        Set<Multa> mockMultaSet = Mockito.mock(Set.class);
        
        
        //Mockito.when()
        
        instance.destroy(id);

    }

    /**
     * Test of findMultaEntities method, of class MultaJpaController.
     */
    @Test
    public void testFindMultaEntities_int_int() {
        System.out.println("findMultaEntities");
        Multa mockMulta = Mockito.mock(Multa.class);
        Long id = mockMulta.getId();
        mockMulta.setId(id);
        EntityManagerFactory mockEMF = Mockito.mock(EntityManagerFactory.class);
        MultaJpaController instance = new MultaJpaController(mockEMF);
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        Mockito.when(instance.getEntityManager()).thenReturn(mockEM);
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);
        
        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery()).thenReturn(mockCQ);
        
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
        Mockito.when(mockEM.createQuery(mockCQ)).thenReturn(mockTQ);       
        
        List<Multa> mockList = Mockito.mock(List.class);
        mockTQ.setMaxResults(mockList.size());
        mockTQ.setFirstResult(0);
        
        int maxResults = mockList.size();
        int firstResult = 0;

        List <Multa> expResult = mockTQ.getResultList();
        List<Multa> result = instance.findMultaEntities(maxResults, firstResult);
        assertEquals(expResult, result);

    }
    
//
//    /**
//     * Test of findMulta method, of class MultaJpaController.
//     */
//    @Test
//    public void testFindMulta() {
//        System.out.println("findMulta");
//        Long id = null;
//        MultaJpaController instance = null;
//        Multa expResult = null;
//        Multa result = instance.findMulta(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMultaCount method, of class MultaJpaController.
//     */
//    @Test
//    public void testGetMultaCount() {
//        System.out.println("getMultaCount");
//        MultaJpaController instance = null;
//        int expResult = 0;
//        int result = instance.getMultaCount();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
