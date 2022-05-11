import java.util.Scanner;
import java.util.TreeSet;

public class PrincipalTreeSet {
    public static void main(String[] args) {
        int opcion;
        ArbolTreeSet ab = new ArbolTreeSet();
        Scanner entrada = new Scanner(System.in);
        TreeSet<Integer> ts = new TreeSet<Integer>();
        Nodo raiz = new Nodo();

        do {
            System.out.println("1.Ingresar nuevo alumno");
            System.out.println("2. Visualizar datos de los alumnos");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Headset");
            System.out.println("6. Tailset");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("ingresa el numero de matricula");
                    insertarAlumno(raiz, entrada.nextInt());
                    ab.ingresar(ts);
                    break;
                case 2:
                    ab.visualizar(ts);
                    break;
                case 3:
                    System.out.println("Ingrese el valor a buscar");
                    System.out.println("Elemento encontrado: " + ab.buscar(ts, entrada.nextInt()));
                    break;
                case 4:
                    System.out.println("Ingrese el valor a eliminar");
                    ab.eliminar(ts, entrada.nextInt());
                    break;
                case 5:
                    System.out.println("Ingrese la calificacion menor o igual a buscar");
                    System.out.println("Elemento encontrado: " + ab.buscar(ts, entrada.nextInt()));
                    break;
                case 6:
                    System.out.println("Ingrese el valor de matricula ");
                    System.out.println("Elemento encontrado: " + ab.buscar(ts, entrada.nextInt()));
                    break;
            }
        } while (opcion < 7);
    }
    
    
    private static void Busqueda(Nodo raiz, int valorBuscado) {

        if (valorBuscado < raiz.getDato()) {
            if (raiz.getIzq() == null) {
                System.out.println("Valor no encontrado");
            } else {
                Busqueda(raiz.getIzq(), valorBuscado);
            }
        } else {
            if (valorBuscado > raiz.getDato()) {
                if (raiz.getDer() == null) {
                    System.out.println("Valor no encontrado");
                } else {
                    Busqueda(raiz.getDer(), valorBuscado);
                }
            } else {
                System.out.println("Valor Encontrado: " + raiz.getDato() + "Existe");
            }
        }

    }

    private static void elegirRecorrido(Nodo raiz) {
        Recorridos r = new Recorridos();
        System.out.println("Recorrido en preorden");
        r.preorden(raiz);

        System.out.println("Recorrido en inorden");
        r.inorden(raiz);

        System.out.println("Recorrido en postorden");
        r.postorden(raiz);
    }

    public static void insertarAlumno(Nodo raiz, int ValorNuevo) {
        if (ValorNuevo < raiz.getDato()) {

            if (raiz.getIzq() == null) {
                Nodo nodoNuevo = new Nodo(ValorNuevo);
                raiz.setIzq(nodoNuevo);
            } else {
                insertarAlumno(raiz.getIzq(), ValorNuevo);
            }

        } else {
            if (ValorNuevo > raiz.getDato()) {
                if (raiz.getDer() == null) {
                    Nodo nodoNuevo = new Nodo(ValorNuevo);
                    raiz.setDer(nodoNuevo);
                } else {
                    insertarAlumno(raiz.getDer(), ValorNuevo);
                }
            } else {
                System.out.println("El valor ya Existe");
            }
        }

    }

    public static void eliminar(Nodo raiz, int eliminado) {
        boolean bandera;
        Nodo otroNodo = new Nodo();
        Nodo aux = new Nodo();
        Nodo aux1 = new Nodo();

        if (raiz != null) {

            if (eliminado < raiz.getDato()) {
                eliminar(raiz.getIzq(), eliminado);
            } else {

                if (eliminado > raiz.getDato()) {
                    eliminar(raiz.getDer(), eliminado);
                } else {// Valor a eliminar es el valor en el nodo //Revisar eliminar hoja
                    otroNodo = raiz;

                    if (otroNodo.getDer() == null) {
                        raiz = otroNodo.getIzq();
                    } else {

                        if (otroNodo.getIzq() == null) {
                            raiz = otroNodo.getDer();
                        } else {
                            aux = raiz.getIzq();
                            bandera = false;

                            while (aux.getDer() != null) {
                                aux1 = aux;
                                aux = aux.getDer();
                                bandera = true;
                            }
                            raiz.setDato(aux.getDato());
                            otroNodo = aux;

                            if (bandera == true) {
                                aux1.setDer(aux.getIzq());
                            } else {
                                raiz.setIzq(aux.getIzq());
                            }
                        }
                    }
                    otroNodo = null;
                }
            }
        } else {
            System.out.println("La informacion no se encuentra");
        }
    }

}

}
