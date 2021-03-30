/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author larok
 */
@ExtendWith(MockitoExtension.class)
public class LibroTest {

    static Libro registro = new Libro();
    Date fechaprueba = new Date(121, 10, 11,16,30,10);
    public LibroTest() {
    }

    @BeforeAll
    public static void setUpClass() throws ParseException {
        registro.setAutor("Paquito");
        Date fechaprueba = new Date(121, 10, 11,16,30,10);
        System.out.println(DateFormat.getDateInstance().format(fechaprueba));
        registro.setFechaAlta(fechaprueba);
        registro.setIsbn("Isbnprueba");
    }

    @AfterAll
    public static void tearDownClass() {
        registro = null;
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Libro instance = new Libro();
        instance.setId(1);
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 1;
        Libro instance = Mockito.mock(Libro.class);
        instance.setId(id);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetAutor() {
        System.out.println("getAutor");
        String expResult = "Paquito";
        String result = this.registro.getAutor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetAutor() {
        System.out.println("setAutor");
        String autor = "Paquito";
        Libro instance = Mockito.mock(Libro.class);
        instance.setAutor(autor);
        Mockito.verify(instance).setAutor(autor);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetFechaAlta() throws ParseException {
        System.out.println("getFechaAlta");
        Date expResult = fechaprueba;
        Date result = this.registro.getFechaAlta();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    @Test
    public void testSetFechaAlta() {
        //preguntarle a margueiz
        System.out.println("setFechaAlta");
        Date fechaAlta = fechaprueba;
        Libro instance = Mockito.mock(Libro.class);
        instance.setFechaAlta(fechaAlta);
        Mockito.verify(instance).setFechaAlta(fechaAlta);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetIsbn() {
        System.out.println("getIsbn");
        String expResult = "Isbnprueba";
        String result = this.registro.getIsbn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIsbn method, of class Libro.
     */
    @Test
    public void testSetIsbn() {
        System.out.println("setIsbn");
        String isbn = "Isbnprueba";
        Libro instance = Mockito.mock(Libro.class);
        instance.setIsbn(isbn);
        Mockito.verify(instance).setIsbn(isbn);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


//    @Test
//    public void testGetNumDisponibles() {
//        System.out.println("getNumDisponibles");
//        Libro instance = new Libro();
//        Integer expResult = null;
//        Integer result = instance.getNumDisponibles();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setNumDisponibles method, of class Libro.
//     */
//    @Test
//    public void testSetNumDisponibles() {
//        System.out.println("setNumDisponibles");
//        Integer numDisponibles = null;
//        Libro instance = new Libro();
//        instance.setNumDisponibles(numDisponibles);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getNumPaginas method, of class Libro.
//     */
//    @Test
//    public void testGetNumPaginas() {
//        System.out.println("getNumPaginas");
//        Libro instance = new Libro();
//        Integer expResult = null;
//        Integer result = instance.getNumPaginas();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setNumPaginas method, of class Libro.
//     */
//    @Test
//    public void testSetNumPaginas() {
//        System.out.println("setNumPaginas");
//        Integer numPaginas = null;
//        Libro instance = new Libro();
//        instance.setNumPaginas(numPaginas);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTitulo method, of class Libro.
//     */
//    @Test
//    public void testGetTitulo() {
//        System.out.println("getTitulo");
//        Libro instance = new Libro();
//        String expResult = "";
//        String result = instance.getTitulo();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setTitulo method, of class Libro.
//     */
//    @Test
//    public void testSetTitulo() {
//        System.out.println("setTitulo");
//        String titulo = "";
//        Libro instance = new Libro();
//        instance.setTitulo(titulo);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEjemplarSet method, of class Libro.
//     */
//    @Test
//    public void testGetEjemplarSet() {
//        System.out.println("getEjemplarSet");
//        Libro instance = new Libro();
//        Set<Ejemplar> expResult = null;
//        Set<Ejemplar> result = instance.getEjemplarSet();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setEjemplarSet method, of class Libro.
//     */
//    @Test
//    public void testSetEjemplarSet() {
//        System.out.println("setEjemplarSet");
//        Set<Ejemplar> ejemplarSet = null;
//        Libro instance = new Libro();
//        instance.setEjemplarSet(ejemplarSet);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getReservaSet method, of class Libro.
//     */
//    @Test
//    public void testGetReservaSet() {
//        System.out.println("getReservaSet");
//        Libro instance = new Libro();
//        Set<Reserva> expResult = null;
//        Set<Reserva> result = instance.getReservaSet();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setReservaSet method, of class Libro.
//     */
//    @Test
//    public void testSetReservaSet() {
//        System.out.println("setReservaSet");
//        Set<Reserva> reservaSet = null;
//        Libro instance = new Libro();
//        instance.setReservaSet(reservaSet);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class Libro.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Libro instance = new Libro();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
}
