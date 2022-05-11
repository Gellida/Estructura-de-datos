import java.util.ArrayList;

public class Recorridos {

    public void inorden(Nodo raiz) {
        if (raiz != null) {
            inorden(raiz.getIzq());
            System.out.println(raiz.getDato());
            inorden(raiz.getDer());
        }
    }

    public void preorden(Nodo raiz) {
        if (raiz != null) {
            System.out.println(raiz.getDato());
            preorden(raiz.getIzq());
            preorden(raiz.getDer());
        }
    }

    public void postorden(Nodo raiz) {
        if (raiz != null) {
            postorden(raiz.getIzq());
            postorden(raiz.getDer());
            System.out.println(raiz.getDato());
        }

    }
    public ArrayList<Producto> guardarInorden(Nodo raiz, ArrayList<Producto> lista) {
        if (raiz != null) {
            guardarInorden(raiz.getIzq(), lista);
            lista.add(raiz.getDato());
            guardarInorden(raiz.getDer(), lista);
        }
        return lista;
    }

}
