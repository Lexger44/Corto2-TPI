/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author cmargueiz
 */
@ExtendWith(MockitoExtension.class)
public class HistoricoTest {
    
    public HistoricoTest() {
        
        
    }
    
    @BeforeEach
    public void setUp() {
    }

    /**
     * Test of getId method, of class Historico.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Historico instance = new Historico();
        instance.setId(9L);
        Long expResult = 9L;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Historico.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        Historico instance = Mockito.mock(Historico.class);
        instance.setId(id);
        Mockito.verify(instance).setId(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of getFechaDevolucion method, of class Historico.
//     */
//    @Test
//    public void testGetFechaDevolucion() {
//        System.out.println("getFechaDevolucion");
//        Historico instance = new Historico();
//        Date expResult = null;
//        Date result = instance.getFechaDevolucion();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setFechaDevolucion method, of class Historico.
//     */
//    @Test
//    public void testSetFechaDevolucion() {
//        System.out.println("setFechaDevolucion");
//        Date fechaDevolucion = null;
//        Historico instance = new Historico();
//        instance.setFechaDevolucion(fechaDevolucion);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFechaDevolucionReal method, of class Historico.
//     */
//    @Test
//    public void testGetFechaDevolucionReal() {
//        System.out.println("getFechaDevolucionReal");
//        Historico instance = new Historico();
//        Date expResult = null;
//        Date result = instance.getFechaDevolucionReal();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setFechaDevolucionReal method, of class Historico.
//     */
//    @Test
//    public void testSetFechaDevolucionReal() {
//        System.out.println("setFechaDevolucionReal");
//        Date fechaDevolucionReal = null;
//        Historico instance = new Historico();
//        instance.setFechaDevolucionReal(fechaDevolucionReal);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFechaPrestamo method, of class Historico.
//     */
//    @Test
//    public void testGetFechaPrestamo() {
//        System.out.println("getFechaPrestamo");
//        Historico instance = new Historico();
//        Date expResult = null;
//        Date result = instance.getFechaPrestamo();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setFechaPrestamo method, of class Historico.
//     */
//    @Test
//    public void testSetFechaPrestamo() {
//        System.out.println("setFechaPrestamo");
//        Date fechaPrestamo = null;
//        Historico instance = new Historico();
//        instance.setFechaPrestamo(fechaPrestamo);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEjemplarId method, of class Historico.
//     */
//    @Test
//    public void testGetEjemplarId() {
//        System.out.println("getEjemplarId");
//        Historico instance = new Historico();
//        Ejemplar expResult = null;
//        Ejemplar result = instance.getEjemplarId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setEjemplarId method, of class Historico.
//     */
//    @Test
//    public void testSetEjemplarId() {
//        System.out.println("setEjemplarId");
//        Ejemplar ejemplarId = null;
//        Historico instance = new Historico();
//        instance.setEjemplarId(ejemplarId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getUsuarioId method, of class Historico.
//     */
//    @Test
//    public void testGetUsuarioId() {
//        System.out.println("getUsuarioId");
//        Historico instance = new Historico();
//        Usuario expResult = null;
//        Usuario result = instance.getUsuarioId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setUsuarioId method, of class Historico.
//     */
//    @Test
//    public void testSetUsuarioId() {
//        System.out.println("setUsuarioId");
//        Usuario usuarioId = null;
//        Historico instance = new Historico();
//        instance.setUsuarioId(usuarioId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of hashCode method, of class Historico.
//     */
//    @Test
//    public void testHashCode() {
//        System.out.println("hashCode");
//        Historico instance = new Historico();
//        int expResult = 0;
//        int result = instance.hashCode();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of equals method, of class Historico.
//     */
//    @Test
//    public void testEquals() {
//        System.out.println("equals");
//        Object object = null;
//        Historico instance = new Historico();
//        boolean expResult = false;
//        boolean result = instance.equals(object);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class Historico.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Historico instance = new Historico();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
