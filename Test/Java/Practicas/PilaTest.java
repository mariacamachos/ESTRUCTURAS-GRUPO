package Practicas;
import Practicas.*;
import org.junit.jupiter.api.Test;
import Practicas.ListaSimplementeEnlazada;

import static org.junit.jupiter.api.Assertions.*;


class PilaTest {

    @Test
    void testPilaYCola() {
        Pila<Integer> pila = new Pila<>();
        pila.push(1);
        pila.push(2);
        assertEquals(2, pila.pop());

        Cola<Integer> cola = new Cola<>();
        cola.enqueue(10);
        cola.enqueue(20);
        assertEquals(10, cola.dequeue());
    }
}