import java.util.Hashtable;
import java.util.Scanner;

public class TestHashtable {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // instancia de varias personas

        Persona p1 = new Persona("Pablo", 33, "Argentino");
        Persona p2 = new Persona("Juan", 25, "Mexicano");
        Persona p3 = new Persona("Pedro", 18, "Español");
        Persona p4 = new Persona("Pablo", 35, "Chileno");
        // creación de la tablas hash

        Hashtable<String, Persona> tabla = new Hashtable<String, Persona>();

        // agrega las personas a la tabla tomando su nombre como clave
        tabla.put(p1.getNombre(), p1);
        tabla.put(p2.getNombre(), p2);
        tabla.put(p3.getNombre(), p3);
        tabla.put(p4.getNombre(), p4);

        System.out.println("Acceso a cada elemento de la tabla por su clave");
        System.out.println("Introduzca la clave de elemento a seleccionar");
        String op = sc.nextLine();
        switch (op) {
            case "Pablo":
                System.out.println(tabla.get("Pablo"));
                break;
            case "Juan":
                System.out.println(tabla.get("Juan"));
                break;
            case "Pedro":
                System.out.println(tabla.get("Pedro"));
                break;

        }

        // Acceso erróneo, el registro no existe
        System.out.println(tabla.get("Rolo"));

    }
}