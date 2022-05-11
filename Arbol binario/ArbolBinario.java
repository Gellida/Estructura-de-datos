
import java.util.Scanner;

public class ArbolBinario {

    public static void main(String[] args) {
        int opc, valor;

        Scanner entrada = new Scanner(System.in);
        Nodo raiz = new Nodo();
        do {
            System.out.println(
                    "1. Crear árbol\n2. Contar nodos\n3. Recorrido\n4. Agregar Nodo \n5. Busqueda\n6.Eliminar");
            opc = entrada.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingresa valor del nodo");
                    valor = entrada.nextInt();
                    raiz.setDato(valor);
                    crearArbol(raiz);
                    break;
                case 2:
                    System.out.println("Total: " + totalNodos(raiz) + " nodos");
                    System.out.println("Total nodos hoja: " + totalHojas(raiz) + " nodo (s)");
                    break;
                case 3:
                    elegirRecorrido(raiz);
                    break;
                case 4:
                    System.out.println("Inserte nuevo nodo");
                    insertarNodo(raiz, entrada.nextInt());
                    break;
                case 5:
                    int valorBuscado;
                    System.out.println("Introduce el valor buscado");
                    valorBuscado = entrada.nextInt();
                    Busqueda(raiz, valorBuscado);
                    break;
                case 6:
                    int eliminado;
                    System.out.println("Introduce el nodo a eliminar");
                    eliminado = entrada.nextInt();
                    eliminar(raiz, eliminado);
                    break;

            }
        } while (opc < 7 && opc > 0);
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

    public static void crearArbol(Nodo nodoPadre) {
        int valor, respuesta;
        Scanner entrada = new Scanner(System.in);

        System.out.println("¿Existe nodo por la izquierda para " + nodoPadre.getDato() + ":(1)SI (2)NO?");
        respuesta = entrada.nextInt();

        if (respuesta == 1) {
            System.out.println("Ingrese valor del nodo");
            valor = entrada.nextInt();
            Nodo subizq = new Nodo(valor); // Raíz del subárbol izquierdo
            nodoPadre.setIzq(subizq);// enlace
            crearArbol(subizq);
        }

        System.out.println("¿Existe nodo por la derecha para " + nodoPadre.getDato() + ":(1)SI (2)NO?");
        respuesta = entrada.nextInt();
        if (respuesta == 1) {
            System.out.println("Ingrese valor del nodo");
            valor = entrada.nextInt();
            Nodo subder = new Nodo(valor); // Raíz del subárbol derecho
            nodoPadre.setDer(subder);// enlace
            crearArbol(subder);
        }
    }

    public static int totalNodos(Nodo raiz) {
        if (raiz != null)
            return 1 + totalNodos(raiz.getIzq()) + totalNodos(raiz.getDer());
        else
            return 0;
    }

    public static int totalHojas(Nodo raiz) {
        if (raiz != null) {
            if (raiz.getIzq() == null && raiz.getDer() == null) {// Es un nodo hoja
                return 1;
            } else {
                return totalHojas(raiz.getIzq()) + totalHojas(raiz.getDer());
            }
        } else
            return 0;
    }

    public static void insertarNodo(Nodo raiz, int ValorNuevo) {
        if (ValorNuevo < raiz.getDato()) {

            if (raiz.getIzq() == null) {
                Nodo nodoNuevo = new Nodo(ValorNuevo);
                raiz.setIzq(nodoNuevo);
            } else {
                insertarNodo(raiz.getIzq(), ValorNuevo);
            }

        } else {
            if (ValorNuevo > raiz.getDato()) {
                if (raiz.getDer() == null) {
                    Nodo nodoNuevo = new Nodo(ValorNuevo);
                    raiz.setDer(nodoNuevo);
                } else {
                    insertarNodo(raiz.getDer(), ValorNuevo);
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
