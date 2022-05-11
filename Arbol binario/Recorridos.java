
public class Recorridos extends ArbolBinario {

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

}
