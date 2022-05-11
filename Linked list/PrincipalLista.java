import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class PrincipalLista {
    static LinkedList<Variable> listaNodos = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = menu();
        } while (opcion != 3);
    }

    public static int menu() {
        int opcion;
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Agrega la variable");
        System.out.println("2. Visualizar primer registro");
        // System.out.println("3. Visualizar todos los registros");

        listaNodos.add(new Variable(2, 3));
        listaNodos.add(new Variable(1, 2));
        listaNodos.add(new Variable(1, 1));

        System.out.println(listaNodos);

        opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                registroVariable();
                break;
            case 2:
                System.out.println(listaNodos.getFirst().resultado());
                break;
            // case 3: visualizarLista(); break;
        }
        return opcion;
    }

    /*
     * public static void visualizarLista(){ for (Alumno a:listaNodos)
     * System.out.println (a.resultado()); }
     */
    public static void registroVariable() {
        int Variable, cantidad;
        String nombre;

        do {
            System.out.print("agrega el valor de X ");
            cantidad = sc.nextInt();
        } while (cantidad < 0);
        sc.nextLine();

        System.out.print("Matrícula: ");
        Variable = sc.nextInt();
        System.out.print("Nombre: ");
        nombre = sc.next();

        sc.nextLine();

        // listaNodos.add(new Variable(coef, exp));

    }
}
