import java.util.Scanner;

public class Main {
    public static Scanner sc= new Scanner(System.in);
    public static GrafoUnion grafo;
    
    public static void main(String[] args) {
        int op;
        Nodo[] nodos;
        
        do {
            System.out.println("Menu de opciones:\n1. Crear grafo\n2. Imprimir grafo\n 3. Cantidad de nodos");
            op= sc.nextInt();

            switch (op) {
                case 1:
                    int cant;
                    System.out.println("Ingrese la cantidad de nodos que tiene el grafo: ");
                    cant=sc.nextInt();
                    nodos=new Nodo[cant];
                    crearGrafo(nodos, cant);
                    grafo = new GrafoUnion();
                    for (int i = 0; i < nodos.length; i++) {
                        grafo.agregarNodo(nodos[i]);
                    }
                    break;
            
                case 2:
                    if(grafo==null){
                        System.out.println("El grafo es nulo");
                    }else{
                        System.out.println(grafo);
                    }
                    
                break;

                case 3: 
                    if(grafo==null){
                        System.out.println("El grafo es nulo");
                    }else{
                        System.out.println("Cantida de nodos del grafo: " + grafo.size());
                    }
                    
                break;
            }

        } while (op>0 && op<4);
        
    }

    public static void crearGrafo(Nodo[] nodos, int cant){
        
        sc.nextLine();
        for (int i = 0; i < cant; i++) {
            
            System.out.println("Ingrese el valor del nodo[" + (i+1) + "]: ");
            Nodo aux = new Nodo(sc.nextLine());
            nodos[i]=aux;
        }

        crearAristas(nodos);

    }

    public static void crearAristas(Nodo[] nodos) {
        int cant;

        sc.nextLine();
        for (int i = 0; i < nodos.length; i++) {

            System.out.println("Ingrese la cantidad de aristas para el nodo * "+ nodos[i].getDato()+" *");
            cant = sc.nextInt();
            
            for (int j = 0; j < cant; j++) {
                String aux;
                int peso;
                Nodo auxBand;
                
                do{
                    sc.nextLine();
                    System.out.println("Ingrese el valor del nodo destino: ");
                    aux=sc.nextLine();
                    System.out.println("Ingrese el valor del peso: ");
                    peso=sc.nextInt();

                    auxBand=getDestino(aux, nodos);
                    nodos[i].setAristas(new Conexion(nodos[i], auxBand, peso));
                }while(auxBand==null);
                
            }
        }   
        
        
    }

    public static Nodo getDestino(String obj, Nodo[] nodos){
        Nodo band=null;
        for (int i = 0; i < nodos.length; i++) {
            if (nodos[i].getDato().equals(obj)){
               band=nodos[i]; 
            }
        }
        if(band==null){
            System.out.println("No se encontró el nodo destino en los nodos ingresados ***intente de nuevo***");
        }
        return band;
    }
}
