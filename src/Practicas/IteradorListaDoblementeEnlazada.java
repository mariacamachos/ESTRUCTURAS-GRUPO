package Practicas;

/** Implementación de un iterador para una lista simplemente enlazada */
public class IteradorListaDoblementeEnlazada<T> implements Iterador<T> {
    private ElementoDoble<T> actual; // Nodo actual del iterador
    private ElementoDoble<T> previo; // Nodo previo al actual, para eliminar el nodo actual

    /** Constructor que recibe el nodo inicial de la lista */
    public IteradorListaDoblementeEnlazada(ElementoDoble<T> inicio) {
        this.actual = inicio;
        this.previo = null;
    }

    /** Método que verifica si hay un nodo siguiente en la lista */
    @Override
    public boolean hasNext() {
        return actual != null;
    }

    /** Método que avanza al siguiente nodo y devuelve su dato */
    @Override
    public T next() {
        if (actual != null) {
            T dato = actual.dato;
            previo = actual;
            actual = actual.siguiente;  // Primero avanzamos
            return dato;  // Luego retornamos el valor del nodo
        }
        return null;
    }

    /** Método que elimina el último elemento retornado por next */
    @Override
    public void delete() {
        if (actual == null) {
            return;  // Si no hay nodo actual, no podemos eliminar nada
        }

        // Si el nodo actual no es el primero (es decir, tiene un nodo previo)
        if (previo != null) {
            previo.siguiente = actual.siguiente; // El nodo previo apunta al siguiente del nodo actual
            if (actual.siguiente != null) {
                actual.siguiente.anterior = previo; // El siguiente nodo apunta hacia atrás al nodo previo
            }
            actual = actual.siguiente; // Avanzamos el iterador al siguiente nodo
        } else {
            // Si el nodo actual es el primero, simplemente movemos la cabeza al siguiente nodo
            if (actual.siguiente != null) {
                actual.siguiente.anterior = null; // El siguiente nodo no tiene nodo previo
            }
            actual = actual.siguiente;  // Avanzamos el iterador al siguiente nodo
        }
    }
}
