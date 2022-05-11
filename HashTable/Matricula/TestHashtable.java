import java.util.Hashtable;
import java.util.Scanner;

public class TestHashtable {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // instancia de varias personas

        Persona p1 = new Persona("IDS", "Pablo", 203451, "Primero");
        Persona p2 = new Persona("IDS", "Jose", 203631, "Tercero");

        // creación de la tablas hash

        Hashtable<Integer, Persona> tabla = new Hashtable<Integer, Persona>();

        // agrega las personas a la tabla tomando su nombre como clave
        tabla.put(p1.getMatricula(), p1);
        tabla.put(p2.getMatricula(), p2);

        System.out.println("Acceso a cada elemento de la tabla por su clave");
        System.out.println("Introduzca la clave de elemento a seleccionar");
        String op = sc.nextLine();
        switch (op) {
            case "203451":
                System.out.println(tabla.get(203451));
                break;
            case "203631":
                System.out.println(tabla.get(203631));
                break;

        }

    }
}