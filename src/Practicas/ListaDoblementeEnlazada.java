package Practicas;

/** Implementación de una lista doblemente enlazada */
class ListaDoblementeEnlazada<T> implements Lista<T> {
    private ElementoDoble<T> cabeza;
    private ElementoDoble<T> cola;
    private int numElementos;

    public ListaDoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.numElementos = 0;
    }

    @Override
    public boolean add(T elemento) {
        ElementoDoble<T> nuevo = new ElementoDoble<>(elemento);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        numElementos++;
        return true;
    }

    @Override
    public boolean delete(T elemento) {
        ElementoDoble<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(elemento)) {
                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente;
                } else {
                    cabeza = actual.siguiente;
                }
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior;
                } else {
                    cola = actual.anterior;
                }
                numElementos--;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public Iterador<T> getIterador() {
        return new IteradorListaDoblementeEnlazada<>(cabeza);
    }

    @Override
    public int getNumElementos() {
        return numElementos;
    }
}
