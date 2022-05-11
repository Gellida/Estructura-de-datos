import java.util.*;


public class Main {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int op;
        Nodo raiz = new Nodo();
        Recorridos r = new Recorridos();

        try {
            verProductos(raiz);
        } catch (Exception e) {
            System.out.println("No se encontro el archivo");
        }

        do {
            System.out.println("(1)Agregar producto\n(2)Vender producto\n(3)Ver productos\n(4)Salir");
            op = entrada.nextInt();
            switch (op) {
                case 1:
                    agregarProducto(raiz);
                    actualizar(raiz, r);
                    break;
                case 2:
                    String eliminar;
                    System.out.println("Seleccione el producto");
                    eliminar = entrada.next();
                    r.inorden(raiz);
                    busquedacodigo(raiz, eliminar, raiz);
                    actualizar(raiz, r);
                    break;
                case 3:
                    r.inorden(raiz);
                    break;
            }
        } while (op < 4);

    }

    public static void agregarProducto(Nodo raiz) {
        int cantidad, precio;
        String codigo, nombre;

        System.out.println("introduce un nuevo codigo para tu software");
        codigo = entrada.next();
        System.out.println("digita el nombre del producto");
        nombre = entrada.next();
        System.out.println("digita la cantidad disponible");
        cantidad = entrada.nextInt();
        System.out.println("digita el precio");
        precio = entrada.nextInt();

        Producto p = new Producto(codigo, nombre, cantidad, precio);
        busqueda(raiz, p);
    }

    public static void verProductos(Nodo raiz) throws IOException {
        String artexto;
        int cantidad, precio;
        int contador = 1;
        String linea;

        File archivo = new File("productos.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);

        while ((linea = br.readLine()) != null) {
            artexto = linea;
            String[] partes = artexto.split(" ");
            cantidad = Integer.parseInt(partes[2]);
            precio = Integer.parseInt(partes[3]);
            Producto p = new Producto(partes[0], partes[1], cantidad, precio);
            if (contador == 1) {
                raiz.setDato(p);
                raiz.setDer(null);
                raiz.setIzq(null);
            }
            contador++;
            insertarNodo(raiz, p);
        }
        fr.close();

    }

    public static void actualizar(Nodo raiz, Recorridos r) throws IOException {
        aux.clear();
        aux = r.imprimirIn(raiz, aux);
        File f = new File("productos.txt");
        String cadena = "";

        for (int i = 0; i < aux.size(); i++) {
            cadena += aux.get(i) + "\n";
        }
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.append(cadena);
            wr.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void insertarNodo(Nodo raiz, Producto ValorNuevo) {
        if (ValorNuevo.compareTo(raiz.getDato()) < 0) {

            if (raiz.getIzq() == null) {
                Nodo nodoNuevo = new Nodo(ValorNuevo);
                raiz.setIzq(nodoNuevo);
            } else {
                insertarNodo(raiz.getIzq(), ValorNuevo);
            }

        } else {
            if (ValorNuevo.compareTo(raiz.getDato()) > 0) {
                if (raiz.getDer() == null) {
                    Nodo nodoNuevo = new Nodo(ValorNuevo);
                    raiz.setDer(nodoNuevo);
                } else {
                    insertarNodo(raiz.getDer(), ValorNuevo);
                }
            }
        }

    }

    public static void busqueda(Nodo raiz, Producto valorBuscado) {
        int ca = valorBuscado.getCantidad();

        if (valorBuscado.compareTo(raiz.getDato()) < 0) {
            if (raiz.getIzq() == null) {
                raiz.setIzq(new Nodo(valorBuscado));
            } else {
                busqueda(raiz.getIzq(), valorBuscado);
            }
        } else {
            if (valorBuscado.compareTo(raiz.getDato()) > 0) {
                if (raiz.getDer() == null) {
                    raiz.setDer(new Nodo(valorBuscado));
                } else {
                    busqueda(raiz.getDer(), valorBuscado);
                }
            } else {
                System.out.println("Este valor ya existe" + raiz.getDato());
                raiz.getDato().setCantidad(ca + raiz.getDato().getCantidad());
            }
        }

    }

    public static void busquedacodigo(Nodo raiz, String valorBuscado, Nodo raizPrincipal) {
        System.out.println(raiz.getDato() + " " + raizPrincipal.getDato());

        if (valorBuscado.compareTo(raiz.getDato().getCodigo()) < 0) {
            if (raiz.getIzq() == null) {
                System.out.println("No se encontro el dato");
            } else {
                busquedacodigo(raiz.getIzq(), valorBuscado, raizPrincipal);
            }
        } else {
            if (valorBuscado.compareTo(raiz.getDato().getCodigo()) > 0) {
                if (raiz.getDer() == null) {
                    System.out.println("No se encontro el dato");
                } else {
                    System.out.println("Valor encontrado" + raiz.getDato());
                    busquedacodigo(raiz.getDer(), valorBuscado, raizPrincipal);
                }
            } else {
                System.out.println("valor encontrado");
                venta(raiz, valorBuscado, raizPrincipal);
            }
        }

    }

    public static void venta(Nodo raiz, String valorBuscado, Nodo raizPrincipal) {
        int venta;

        System.out.println("Cantidad a vender");
        venta = entrada.nextInt();
        raiz.getDato().setCantidad(raiz.getDato().getCantidad() - venta);
        if (raiz.getDato().getCantidad() == 0) {
            System.out.println("No hay productos en stock");
            System.out.println(raiz.getDato());
            raizPrincipal = eliminar(raizPrincipal, raiz.getDato());

        }

    }

    public static Nodo eliminar(Nodo raiz, Producto valorEliminar) {
        boolean bandera;
        Nodo otroNodo = new Nodo();
        Nodo aux = new Nodo();
        Nodo aux1 = new Nodo();

        if (raiz != null) {
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
}
