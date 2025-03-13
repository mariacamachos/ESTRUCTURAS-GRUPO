package Practicas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
class ListaSimplementeEnlazadaTest {

    @Test
    void add() {
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>(0,null);
        assertTrue(lista.add(10));
        assertTrue(lista.add(20));
        assertEquals(2,lista.getNumElementos());
    }

    @Test
    void delete() {
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>(0,null);
        lista.add(10);
        lista.add(20);
        lista.add(30);

        assertTrue(lista.delete(20));
        assertEquals(2,lista.getNumElementos());
        assertFalse(lista.delete(60));
    }

    @Test
    void getIterador() {
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>(0, null);
        lista.add(1);
        lista.add(2);
        lista.add(3);

        Iterador<Integer> iterador = lista.getIterador();

        assertNotNull(iterador);
        assertTrue(iterador.hasNext());
        assertEquals(1, iterador.next());
        assertEquals(2, iterador.next());
        assertEquals(3, iterador.next());
        assertFalse(iterador.hasNext());

    }

    @Test
    void getNumElementos() {
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>(0, null);
        assertEquals(0, lista.getNumElementos());

        lista.add(5);
        lista.add(15);
        assertEquals(2, lista.getNumElementos());

        lista.delete(5);
        assertEquals(1, lista.getNumElementos());
    }
}