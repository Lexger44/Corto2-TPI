/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.entity.Reserva;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
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
        ReservaJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
  
    }

    /**
     * Test of create method, of class ReservaJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Reserva reserva = null;
        ReservaJpaController instance = null;
        instance.create(reserva);
   
    }

    /**
     * Test of edit method, of class ReservaJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Reserva reserva = null;
        ReservaJpaController instance = null;
        instance.edit(reserva);
   
    }

    /**
     * Test of destroy method, of class ReservaJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Long id = null;
        ReservaJpaController instance = null;
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
        List<Reserva> result = instance.findReservaEntities();
        assertEquals(expResult, result);
  
    }

    /**
     * Test of findReservaEntities method, of class ReservaJpaController.
     */
    @Test
    public void testFindReservaEntities_int_int() {
        System.out.println("findReservaEntities");
        int maxResults = 0;
        int firstResult = 0;
        ReservaJpaController instance = null;
        List<Reserva> expResult = null;
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
        Reserva result = instance.findReserva(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getReservaCount method, of class ReservaJpaController.
     */
    @Test
    public void testGetReservaCount() {
        System.out.println("getReservaCount");
        ReservaJpaController instance = null;
        int expResult = 0;
        int result = instance.getReservaCount();
        assertEquals(expResult, result);
   
    }
    
}
