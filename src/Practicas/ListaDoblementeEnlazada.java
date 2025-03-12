package Practicas;


/**
 * Implementación de una lista doblemente enlazada.
 * Implementa la interfaz Lista<T> y proporciona métodos para manipular la lista.
 */
public class ListaDoblementeEnlazada<T> implements Lista<T> {
    private ElementoDoble<T> cabeza;
    private ElementoDoble<T> cola;
    private int numElementos = 0;

    /**
     * Agrega un elemento al final de la lista.
     * @param elemento Elemento a agregar.
     * @return true si el elemento se agregó correctamente.
     */
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

    /**
     * Elimina un elemento de la lista.
     * @param elemento Elemento a eliminar.
     * @return true si el elemento estaba en la lista y fue eliminado.
     */
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

    /**
     * Retorna un iterador para recorrer la lista.
     * @return Iterador de la lista.
     */
    @Override
    public Iterador<T> getIterador() {
        return new IteradorListaDoblementeEnlazada<>(cabeza);
    }

    /**
     * Retorna el número de elementos en la lista.
     * @return Cantidad de elementos en la lista.
     */
    @Override
    public int getNumElementos() {
        return numElementos;
    }
}