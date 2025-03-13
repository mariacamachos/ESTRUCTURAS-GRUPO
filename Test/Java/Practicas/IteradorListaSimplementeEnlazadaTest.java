package Practicas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class IteradorListaSimplementeEnlazadaTest {

    @Test
    void hasNext() {
        Elemento<Integer> nodo1 = new Elemento<>(10);
        Elemento<Integer> nodo2 = new Elemento<>(20);
        nodo1.siguiente = nodo2;

        IteradorListaSimplementeEnlazada<Integer> iterador = new IteradorListaSimplementeEnlazada<>(nodo1);
        assertTrue(iterador.hasNext());
        iterador.next();
        assertTrue(iterador.hasNext());
        iterador.next();
        assertFalse(iterador.hasNext());
    }

    @Test
    void next() {
        Elemento<Integer> nodo1 = new Elemento<>(10);
        Elemento<Integer> nodo2 = new Elemento<>(20);
        nodo1.siguiente = nodo2;

        IteradorListaSimplementeEnlazada<Integer> iterador = new IteradorListaSimplementeEnlazada<>(nodo1);
        assertEquals(10, iterador.next());
        assertEquals(20, iterador.next());
        assertNull(iterador.next());
    }

    @Test
    void delete() {
        Elemento<Integer> nodo1 = new Elemento<>(10);
        Elemento<Integer> nodo2 = new Elemento<>(20);
        Elemento<Integer> nodo3 = new Elemento<>(30);
        nodo1.siguiente = nodo2;
        nodo2.siguiente = nodo3;

        IteradorListaSimplementeEnlazada<Integer> iterador = new IteradorListaSimplementeEnlazada<>(nodo1);
        iterador.next(); // Avanza a 10
        iterador.delete(); // Elimina 10, ahora la cabeza es 20
        assertEquals(30, iterador.next());
        assertEquals(null, iterador.next());
        assertNull(iterador.next());
    }

}