/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.entity.Bibliotecario;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author carlo
 */
public class BibliotecarioJpaControllerTest {
    
    public BibliotecarioJpaControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getEntityManager method, of class BibliotecarioJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        BibliotecarioJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class BibliotecarioJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Bibliotecario bibliotecario = null;
        BibliotecarioJpaController instance = null;
        instance.create(bibliotecario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class BibliotecarioJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Bibliotecario bibliotecario = null;
        BibliotecarioJpaController instance = null;
        instance.edit(bibliotecario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class BibliotecarioJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Long id = null;
        BibliotecarioJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBibliotecarioEntities method, of class BibliotecarioJpaController.
     */
    @Test
    public void testFindBibliotecarioEntities_0args() {
        System.out.println("findBibliotecarioEntities");
        BibliotecarioJpaController instance = null;
        List<Bibliotecario> expResult = null;
        List<Bibliotecario> result = instance.findBibliotecarioEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBibliotecarioEntities method, of class BibliotecarioJpaController.
     */
    @Test
    public void testFindBibliotecarioEntities_int_int() {
        System.out.println("findBibliotecarioEntities");
        int maxResults = 0;
        int firstResult = 0;
        BibliotecarioJpaController instance = null;
        List<Bibliotecario> expResult = null;
        List<Bibliotecario> result = instance.findBibliotecarioEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBibliotecario method, of class BibliotecarioJpaController.
     */
    @Test
    public void testFindBibliotecario() {
        System.out.println("findBibliotecario");
        Long id = null;
        BibliotecarioJpaController instance = null;
        Bibliotecario expResult = null;
        Bibliotecario result = instance.findBibliotecario(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBibliotecarioCount method, of class BibliotecarioJpaController.
     */
    @Test
    public void testGetBibliotecarioCount() {
        System.out.println("getBibliotecarioCount");
        BibliotecarioJpaController instance = null;
        int expResult = 0;
        int result = instance.getBibliotecarioCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
