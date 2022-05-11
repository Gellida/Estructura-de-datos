import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Software> aux = new ArrayList<Software>();

    public static void main(String[] args) {
        Recorrido r = new Recorrido();
        int seleccionar;
        Nodo raiz = new Nodo();
        try {
            leerProductos(raiz);
        } catch (Exception e) {
            System.out.println("No se encontro el archivo");
        }

        System.out.println("Bienvendio a Software Shop\n que desea realizar?");
        do {
            System.out.println("1-Agregar producto\n2-Vender producto\n3-Ver productos\n4-Salir");
            seleccionar = entrada.nextInt();
            switch (seleccionar) {
                case 1:
                    try {
                        agregarProducto(raiz);
                        actualizarNota(raiz, r);
                    } catch (Exception e) {
                        System.out.println("Error al escribir en el archivo");
                    }
                    break;
                case 2:
                    try {
                        String eliminar;
                        System.out.println("Que producto desea vender");
                        r.inorden(raiz);
                        eliminar = entrada.next();
                        busquedaCodigo(raiz, eliminar, raiz);
                        actualizarNota(raiz, r);
                    } catch (Exception e) {
                        System.out.println("Error al escribir el archivo");
                    }

                    break;
                case 3:
                    System.out.println("Estos son productos disponibles");
                    r.inorden(raiz);
                    break;
            }
        } while (seleccionar < 4);

    }

    // ------------------------------------------------------------
    // ------------------------------------------------------------
    public static void leerProductos(Nodo raiz) throws IOException {
        String texto;
        int cantidad, precio;
        int contador = 1;
        File archivo = new File("productos.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);

        String linea;
        while ((linea = br.readLine()) != null) {
            texto = linea;
            String[] partes = texto.split("-");
            cantidad = Integer.parseInt(partes[2]);
            precio = Integer.parseInt(partes[3]);
            Software s = new Software(partes[0], partes[1], cantidad, precio);
            if (contador == 1) {
                raiz.setDato(s);
                raiz.setDer(null);
                raiz.setIzq(null);
            }
            contador++;
            insertarNodo(raiz, s);
        }
        fr.close();

    }

    // ------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------
    public static void insertarNodo(Nodo raiz, Software valorNuevo) {
        if (valorNuevo.compareTo(raiz.getDato()) < 0) {
            if (raiz.getIzq() == null) {
                Nodo nodoNuevo = new Nodo(valorNuevo);
                raiz.setIzq(nodoNuevo);
            } else {
                insertarNodo(raiz.getIzq(), valorNuevo);
            }
        } else {
            if (valorNuevo.compareTo(raiz.getDato()) > 0) {
                if (raiz.getDer() == null) {
                    Nodo nodoNuevo = new Nodo(valorNuevo);
                    raiz.setDer(nodoNuevo);
                } else {
                    insertarNodo(raiz.getDer(), valorNuevo);
                }

            } else {
                if (valorNuevo.compareTo(raiz.getDato()) == 0)
                    System.out.println("Este valor ya existe");
            }
        }

    }

    // -----------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------
    public static void agregarProducto(Nodo raiz) {
        String codigo, nombre;
        int cantidad, precio;
        System.out.println("Escribe el codigo de el producto");
        codigo = entrada.next();
        System.out.println("Escribe el nombre de el producto");
        nombre = entrada.next();
        System.out.println("Escribe la cantidad de el producto");
        cantidad = entrada.nextInt();
        System.out.println("Escribe el precio de el producto");
        precio = entrada.nextInt();
        Software s = new Software(codigo, nombre, cantidad, precio);
        busqueda(raiz, s);
    }
    // ------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------------------------------------------------------

    // ------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------------------------------------------------------

    public static void busqueda(Nodo raiz, Software vb) {
        int ca = vb.getCantidad();
        System.out.println(ca);
        if (vb.compareTo(raiz.getDato()) < 0) {
            if (raiz.getIzq() == null) {
                raiz.setIzq(new Nodo(vb));
            } else {
                busqueda(raiz.getIzq(), vb);
            }
        } else {
            if (vb.compareTo(raiz.getDato()) > 0) {
                if (raiz.getDer() == null) {
                    raiz.setDer(new Nodo(vb));
                } else {
                    busqueda(raiz.getDer(), vb);
                }
            } else {
                System.out.println("Valor encontrado," + raiz.getDato());
                raiz.getDato().setCantidad(ca + raiz.getDato().getCantidad());
            }
        }

    }

    // ------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------------------------------------------------------
    public static void busquedaCodigo(Nodo raiz, String vb, Nodo raizPrincipal) {
        System.out.println(raiz.getDato() + " " + raizPrincipal.getDato());
        int venta;
        if (vb.compareTo(raiz.getDato().getcodigo()) < 0) {
            if (raiz.getIzq() == null) {
                System.out.println("No se encontro el dato");
            } else {
                busquedaCodigo(raiz.getIzq(), vb, raizPrincipal);
            }
        } else {
            if (vb.compareTo(raiz.getDato().getcodigo()) > 0) {
                if (raiz.getDer() == null) {
                    System.out.println("No se encontro el dato");
                } else {
                    busquedaCodigo(raiz.getDer(), vb, raizPrincipal);
                }
            } else {
                System.out.println("Valor encontrado," + raiz.getDato());
                System.out.println("Cuantos productos desea Vender");
                venta = entrada.nextInt();
                raiz.getDato().setCantidad(raiz.getDato().getCantidad() - venta);
                if (raiz.getDato().getCantidad() == 0) {
                    System.out.println("Se agoto el producto");
                    System.out.println(raiz.getDato());
                    raizPrincipal = eliminar(raizPrincipal, raiz.getDato());

                }
            }
        }

    }

    // ------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------------------------------------------------------
    public static Nodo eliminar(Nodo raiz, Software valorEliminar) {
        boolean bandera;
        Nodo otroNodo = new Nodo();
        Nodo aux = new Nodo();
        Nodo aux1 = new Nodo();

        if (raiz != null) {// 1
            if (valorEliminar.compareTo(raiz.getDato()) < 0) {
                Nodo auxIzq;
                auxIzq = eliminar(raiz.getIzq(), valorEliminar);
                raiz.setIzq(auxIzq);
            } else {

                if (valorEliminar.compareTo(raiz.getDato()) > 0) {
                    Nodo auxDer;
                    auxDer = eliminar(raiz.getDer(), valorEliminar);
                    raiz.setDer(auxDer);
                } else {
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
        return raiz;
    }

    // ------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------------------------------------------------------

    public static void actualizarNota(Nodo raiz, Recorrido r) throws IOException {
        aux.clear();
        aux = r.guardarInorden(raiz, aux);
        File f = new File("productos.txt");// Intancia para poder crear o abrir un archivo txt
        String temp = "";
        for (int i = 0; i < aux.size(); i++) {
            temp += aux.get(i) + "\n";
        }
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.append(temp);
            wr.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
