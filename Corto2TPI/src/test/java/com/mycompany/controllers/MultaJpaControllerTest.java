/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.entity.Multa;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author melvin
 */
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
        MultaJpaController instance = null;
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class MultaJpaController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Multa multa = null;
        MultaJpaController instance = null;
        instance.create(multa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class MultaJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Multa multa = null;
        MultaJpaController instance = null;
        instance.edit(multa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class MultaJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Long id = null;
        MultaJpaController instance = null;
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMultaEntities method, of class MultaJpaController.
     */
    @Test
    public void testFindMultaEntities_0args() {
        System.out.println("findMultaEntities");
        MultaJpaController instance = null;
        List<Multa> expResult = null;
        List<Multa> result = instance.findMultaEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMultaEntities method, of class MultaJpaController.
     */
    @Test
    public void testFindMultaEntities_int_int() {
        System.out.println("findMultaEntities");
        int maxResults = 0;
        int firstResult = 0;
        MultaJpaController instance = null;
        List<Multa> expResult = null;
        List<Multa> result = instance.findMultaEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findMulta method, of class MultaJpaController.
     */
    @Test
    public void testFindMulta() {
        System.out.println("findMulta");
        Long id = null;
        MultaJpaController instance = null;
        Multa expResult = null;
        Multa result = instance.findMulta(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMultaCount method, of class MultaJpaController.
     */
    @Test
    public void testGetMultaCount() {
        System.out.println("getMultaCount");
        MultaJpaController instance = null;
        int expResult = 0;
        int result = instance.getMultaCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
