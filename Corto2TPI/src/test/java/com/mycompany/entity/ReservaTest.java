/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import static com.mycompany.entity.Reserva_.id;
import java.util.Date;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author sofia
 */
@ExtendWith(MockitoExtension.class)
public class ReservaTest {
    static Reserva registro = new Reserva();
    
    public ReservaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {         
        registro.setEstado("activo");
        
    }
    
    @AfterAll
    public static void tearDownClass() {
        registro = null;
    }

    /**
     * Test of getId method, of class Reserva.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Reserva instance = new Reserva();
        instance.setId(9L);
        Long expResult = 9L;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Reserva.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        Reserva instance = Mockito.mock(Reserva.class);
        instance.setId(id);
        Mockito.verify(instance).setId(id);
    }

    /**
     * Test of getEstado method, of class Reserva.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        String expResult = "activo";
        String result = this.registro.getEstado();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstado method, of class Reserva.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        String estado = "activo";
        Reserva instance = Mockito.mock(Reserva.class);
        instance.setEstado(estado);
        Mockito.verify(instance).setEstado(estado);
    }

//    /**
//     * Test of getFecha method, of class Reserva.
//     */
//    @Test
//    public void testGetFecha() {
//        System.out.println("getFecha");
//        Reserva instance = new Reserva();
//        Date expResult = null;
//        Date result = instance.getFecha();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of setFecha method, of class Reserva.
//     */
//    @Test
//    public void testSetFecha() {
//        System.out.println("setFecha");
//        Date fecha = null;
//        Reserva instance = new Reserva();
//        instance.setFecha(fecha);
//    }
//
//    /**
//     * Test of getFechaFin method, of class Reserva.
//     */
//    @Test
//    public void testGetFechaFin() {
//        System.out.println("getFechaFin");
//        Reserva instance = new Reserva();
//        Date expResult = null;
//        Date result = instance.getFechaFin();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of setFechaFin method, of class Reserva.
//     */
//    @Test
//    public void testSetFechaFin() {
//        System.out.println("setFechaFin");
//        Date fechaFin = null;
//        Reserva instance = new Reserva();
//        instance.setFechaFin(fechaFin);
//    }

//    /**
//     * Test of getTipoFinal method, of class Reserva.
//     */
//    @Test
//    public void testGetTipoFinal() {
//        System.out.println("getTipoFinal");
//        Reserva instance = new Reserva();
//        String expResult = "";
//        String result = instance.getTipoFinal();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of setTipoFinal method, of class Reserva.
//     */
//    @Test
//    public void testSetTipoFinal() {
//        System.out.println("setTipoFinal");
//        String tipoFinal = "";
//        Reserva instance = new Reserva();
//        instance.setTipoFinal(tipoFinal);
//    }
//
//    /**
//     * Test of getLibroId method, of class Reserva.
//     */
//    @Test
//    public void testGetLibroId() {
//        System.out.println("getLibroId");
//        String expResult = "El jardin de las mariposas";
//        String result = this.registro.getEstado();
//        assertEquals(expResult, result);
//    }

//    /**
//     * Test of setLibroId method, of class Reserva.
//     */
//    @Test
//    public void testSetLibroId() {
//        System.out.println("setLibroId");
//        String libroId = "El jardin de las mariposas";
//        Reserva instance = Mockito.mock(Reserva.class);
//        instance.setLibroId(libroId);
//        Mockito.verify(instance).setLibroId(libroId);
//    }

    /**
     * Test of getUsuarioId method, of class Reserva.
     */
    @Test
    public void testGetUsuarioId() {
        System.out.println("getUsuarioId");
        Reserva instance = new Reserva();
        Usuario expResult = null;
        Usuario result = instance.getUsuarioId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsuarioId method, of class Reserva.
     */
    @Test
    public void testSetUsuarioId() {
        System.out.println("setUsuarioId");
        Usuario usuarioId = null;
        Reserva instance = new Reserva();
        instance.setUsuarioId(usuarioId);
    }

    /**
     * Test of toString method, of class Reserva.
     */
    @Test
    public void testToString() {
      System.out.println("toString");        
        String expResult = "com.mycompany.entity.Reserva[ id=" + id + " ]";
        String result = this.registro.toString();
        assertEquals(expResult, result);
 
    }
}
