
import java.util.*;

public class GrafoUnion {
   private List<Nodo> listaNodos;
 
    public void agregarNodo(Nodo nodo) {
        if (listaNodos == null) {
            listaNodos = new ArrayList<>();
        }
        listaNodos.add(nodo);
    }
 
    public List<Nodo> getNodos() {
        return listaNodos;
    }

    public int size(){
        return listaNodos.size();
    }
 
    @Override
    public String toString() {
        return "GRAFO [NODOS=" + listaNodos + "\n]";
    }
}
