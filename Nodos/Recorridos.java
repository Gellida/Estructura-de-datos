import java.util.ArrayList;

public class Recorridos {

    public void inorden(Nodo raiz) {
        if (raiz != null) {
            inorden(raiz.getIzq());
            System.out.println(raiz.getDato());
            inorden(raiz.getDer());
        }
    }

    public ArrayList<Producto> imprimirIn(Nodo raiz, ArrayList<Producto> lista) {
        if (raiz != null) {
            imprimirIn(raiz.getIzq(), lista);
            lista.add(raiz.getDato());
            imprimirIn(raiz.getDer(), lista);
        }
        return lista;
    }

}
