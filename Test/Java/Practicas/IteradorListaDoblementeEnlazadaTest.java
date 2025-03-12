package Practicas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteradorListaDoblementeEnlazadaTest {

    @Test
    void testIteradorRecorrido() {
        ElementoDoble<Integer> nodo1 = new ElementoDoble<>(1);
        ElementoDoble<Integer> nodo2 = new ElementoDoble<>(2);
        ElementoDoble<Integer> nodo3 = new ElementoDoble<>(3);

        nodo1.siguiente = nodo2;
        nodo2.anterior = nodo1;
        nodo2.siguiente = nodo3;
        nodo3.anterior = nodo2;

        IteradorListaDoblementeEnlazada<Integer> iterador = new IteradorListaDoblementeEnlazada<>(nodo1);

        assertTrue(iterador.hasNext());
        assertEquals(1, iterador.next());
        assertTrue(iterador.hasNext());
        assertEquals(2, iterador.next());
        assertTrue(iterador.hasNext());
        assertEquals(3, iterador.next());
        assertFalse(iterador.hasNext());
    }
    @Test
    void testEliminarUltimoNodo() {
        ElementoDoble<Integer> nodo1 = new ElementoDoble<>(1);

        IteradorListaDoblementeEnlazada<Integer> iterador = new IteradorListaDoblementeEnlazada<>(nodo1);

        iterador.next(); // nodo1
        iterador.delete(); // Elimina nodo1

        assertFalse(iterador.hasNext());
        assertNull(iterador.next());
    }

    @Test
    void hasNext() {
        ElementoDoble<Integer> nodo = new ElementoDoble<>(10);
        IteradorListaDoblementeEnlazada<Integer> iterador = new IteradorListaDoblementeEnlazada<>(nodo);
        assertTrue(iterador.hasNext());
        iterador.next();
        assertFalse(iterador.hasNext());
    }

    @Test
    void next() {
        ElementoDoble<Integer> nodo1 = new ElementoDoble<>(5);
        ElementoDoble<Integer> nodo2 = new ElementoDoble<>(10);
        nodo1.siguiente = nodo2;
        nodo2.anterior = nodo1;

        IteradorListaDoblementeEnlazada<Integer> iterador = new IteradorListaDoblementeEnlazada<>(nodo1);
        assertEquals(5, iterador.next());
        assertEquals(10, iterador.next());
        assertNull(iterador.next());
    }

    @Test
    void delete() {
        ElementoDoble<Integer> nodo1 = new ElementoDoble<>(7);
        ElementoDoble<Integer> nodo2 = new ElementoDoble<>(14);
        nodo1.siguiente = nodo2;
        nodo2.anterior = nodo1;

        IteradorListaDoblementeEnlazada<Integer> iterador = new IteradorListaDoblementeEnlazada<>(nodo1);
        iterador.next();
        iterador.delete(); // Borra nodo1
        assertEquals(14, iterador.next());
        assertFalse(iterador.hasNext());
    }
}