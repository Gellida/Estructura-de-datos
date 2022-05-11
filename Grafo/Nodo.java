
import java.util.*;

public class Nodo {
    
    
    String dato;
    List<Conexion> listaAristas;
    
    public Nodo (String valor){
        dato=valor;
    }
    public String getDato(){
        return dato;
    }
    public void setDato (String valor){
        dato=valor;
    }
    public List<Conexion> getAristas (){
        return listaAristas;
    }
    
    public void setAristas(Conexion arista) {
        if (listaAristas == null) {
            listaAristas = new ArrayList<>();
        }
        listaAristas.add(arista);
    }
    @Override
     public String toString() {
        return "\n \tNodo [Vertice=" + dato + ", Lista de aristas=" + listaAristas + "]";
    }
}
