package Practicas;

/** Implementación de un iterador para una lista doblemente enlazada */
class IteradorListaDoblementeEnlazada<T> implements Iterador<T> {
    private ElementoDoble<T> actual;
    private ElementoDoble<T> previo;

    public IteradorListaDoblementeEnlazada(ElementoDoble<T> inicio) {
        this.actual = inicio;
        this.previo = null;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        if (actual != null) {
            previo = actual;
            actual = actual.siguiente;
            return previo.dato;
        }
        return null;
    }

    @Override
    public void delete() {
        if (previo == null) {
            return;
        }

        if (previo.anterior != null) {
            previo.anterior.siguiente = actual;
        }

        if (actual != null) {
            actual.anterior = previo.anterior;
        }

        previo = previo.anterior;
    }
}

