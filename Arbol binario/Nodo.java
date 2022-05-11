public class Nodo {
    // Componentes de un Nodo
    private int dato;
    private Nodo izq; // Para enlace por la izquierda
    private Nodo der; // Para enlace por la derecha

    // Constructores del Nodo
    public Nodo(int dato) {
        this.dato = dato;
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

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setIzq(Nodo nodo) {
        izq = nodo;
    }

    public void setDer(Nodo nodo) {
        der = nodo;
    }
}