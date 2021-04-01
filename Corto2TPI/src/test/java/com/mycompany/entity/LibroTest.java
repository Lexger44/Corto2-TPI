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
//import java.util.Set;

/**
 *
 * @author larok
 */
@ExtendWith(MockitoExtension.class)
public class LibroTest {

    static Libro registro = new Libro();
    Date fechaprueba;

    public LibroTest() {
        fechaprueba = new Date(121, 10, 11, 16, 30, 10);
    }

    @BeforeAll
    public static void setUpClass() throws ParseException {
        registro.setAutor("Paquito");
        Date fechaprueba = new Date(121, 10, 11, 16, 30, 10);
        System.out.println(DateFormat.getDateInstance().format(fechaprueba));
        registro.setFechaAlta(fechaprueba);
        registro.setIsbn("Isbnprueba");
        registro.setNumDisponibles(1);
        registro.setNumPaginas(1);
        registro.setTitulo("PanchoVilla");
        Set<Ejemplar> ejemplarprueba = Mockito.mock(Set.class);
        registro.setEjemplarSet(ejemplarprueba);
        Set<Reserva> reservaprueba = Mockito.mock(Set.class);
        registro.setReservaSet(reservaprueba);

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
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 1;
        Libro instance = Mockito.mock(Libro.class);
        instance.setId(id);
        Mockito.verify(instance).setId(id);
    }

    @Test
    public void testGetAutor() {
        System.out.println("getAutor");
        String expResult = "Paquito";
        String result = this.registro.getAutor();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetAutor() {
        System.out.println("setAutor");
        String autor = "Paquito";
        Libro instance = Mockito.mock(Libro.class);
        instance.setAutor(autor);
        Mockito.verify(instance).setAutor(autor);

    }

    @Test
    public void testGetFechaAlta() throws ParseException {
        System.out.println("getFechaAlta");
        Date expResult = fechaprueba;
        Date result = this.registro.getFechaAlta();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetFechaAlta() {
        //preguntarle a margueiz
        System.out.println("setFechaAlta");
        Date fechaAlta = fechaprueba;
        Libro instance = Mockito.mock(Libro.class);
        instance.setFechaAlta(fechaAlta);
        Mockito.verify(instance).setFechaAlta(fechaAlta);

    }

    @Test
    public void testGetIsbn() {
        System.out.println("getIsbn");
        String expResult = "Isbnprueba";
        String result = this.registro.getIsbn();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetIsbn() {
        System.out.println("setIsbn");
        String isbn = "Isbnprueba";
        Libro instance = Mockito.mock(Libro.class);
        instance.setIsbn(isbn);
        Mockito.verify(instance).setIsbn(isbn);
    }

    @Test
    public void testGetNumDisponibles() {
        System.out.println("getNumDisponibles");
        Integer expResult = 1;
        Integer result = this.registro.getNumDisponibles();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNumDisponibles() {
        System.out.println("setNumDisponibles");
        Integer numDisponibles = 1;
        Libro instance = Mockito.mock(Libro.class);
        instance.setNumDisponibles(numDisponibles);
        Mockito.verify(instance).setNumDisponibles(numDisponibles);
    }

    @Test
    public void testGetNumPaginas() {
        System.out.println("getNumPaginas");
        Integer expResult = 1;
        Integer result = this.registro.getNumPaginas();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNumPaginas() {
        System.out.println("setNumPaginas");
        Integer numPaginas = 1;
        Libro instance = Mockito.mock(Libro.class);
        instance.setNumPaginas(numPaginas);
        Mockito.verify(instance).setNumPaginas(numPaginas);
    }

    @Test
    public void testGetTitulo() {
        System.out.println("getTitulo");
        String expResult = "PanchoVilla";
        String result = this.registro.getTitulo();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetTitulo() {
        System.out.println("setTitulo");
        String titulo = "PanchoVilla";
        Libro instance = Mockito.mock(Libro.class);
        instance.setTitulo(titulo);
        Mockito.verify(instance).setTitulo(titulo);

    }

    @Test
    public void testGetEjemplarSet() {
        System.out.println("getEjemplarSet");
        Set<Ejemplar> expResult = this.registro.getEjemplarSet();
        Set<Ejemplar> result = this.registro.getEjemplarSet();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetEjemplarSet() {
        System.out.println("setEjemplarSet");
        Set<Ejemplar> libroSet = Mockito.mock(Set.class);;
        Libro instance = Mockito.mock(Libro.class);
        instance.setEjemplarSet(libroSet);
        Mockito.verify(instance).setEjemplarSet(libroSet);

    }

    @Test
    public void testGetReservaSet() {
        System.out.println("getReservaSet");
        Set<Reserva> expResult = this.registro.getReservaSet();
        Set<Reserva> result = this.registro.getReservaSet();
        assertEquals(expResult, result);
//        Mockito.when(instance.getReservaSet()).thenReturn(expResult);
    }

    @Test
    public void testSetReservaSet() {
        System.out.println("setReservaSet");
        Set<Reserva> libroSet = Mockito.mock(Set.class);;
        Libro instance = Mockito.mock(Libro.class);
        instance.setReservaSet(libroSet);
        Mockito.verify(instance).setReservaSet(libroSet);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Libro instance = new Libro(1);
        String expResult = "com.mycompany.entity.Libro[ id=1 ]";
        String result = instance.toString();
        assertEquals(expResult, result);

    }
}
