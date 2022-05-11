public class Nodo {
    // Componentes de un Nodo
    private Producto dato;
    private Nodo izq; // Para enlace por la izquierda
    private Nodo der; // Para enlace por la derecha

    // Constructores del Nodo
    public Nodo(Producto valorNuevo) {
        this.dato = valorNuevo;
    }

    public Nodo() {
    }

    // Metodos get y set para manipulaci�n de Nodos
    public Nodo getIzq() {
        return izq;
    }

    public Nodo getDer() {
        return der;
    }

    public Producto getDato() {
        return dato;
    }

    public void setDato(Producto dato) {
        this.dato = dato;
    }

    public void setIzq(Nodo nodo) {
        izq = nodo;
    }

    public void setDer(Nodo nodo) {
        der = nodo;
    }
}