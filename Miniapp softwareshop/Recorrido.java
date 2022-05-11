import java.util.ArrayList;

public class Recorrido {

    public void preorden(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.getDato() + "-");
            preorden(raiz.getIzq());
            preorden(raiz.getDer());
        }
    }

    public void inorden(Nodo raiz) {
        if (raiz != null) {
            inorden(raiz.getIzq());
            System.out.println(raiz.getDato());
            inorden(raiz.getDer());
        }
    }

    public ArrayList<Software> guardarInorden(Nodo raiz, ArrayList<Software> lista) {
        if (raiz != null) {
            guardarInorden(raiz.getIzq(), lista);
            lista.add(raiz.getDato());
            guardarInorden(raiz.getDer(), lista);
        }
        return lista;
    }

    public void postorden(Nodo raiz) {
        if (raiz != null) {
            postorden(raiz.getIzq());
            postorden(raiz.getDer());
            System.out.print(raiz.getDato() + "-");
        }
    }
}