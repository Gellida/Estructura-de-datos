import java.util.Iterator;
import java.util.TreeSet;
import java.util.Scanner;

public class ArbolTreeSet {
    Scanner entrada = new Scanner(System.in);

    public void ingresar(TreeSet<Integer> t) {
        int cantidad, matricula, cal;
        System.out.println("cantidad de alumnnos que deseas ingresar");
        cantidad = entrada.nextInt();
        for (int i = 1; i <= cantidad; i++) {
            System.out.println("Ingresa matricula");
            matricula = entrada.nextInt();
            System.out.println("Ingresa calificacion");
            cal = entrada.nextInt();
            t.add(matricula);
        }
    }

    public void visualizar(TreeSet<Integer> t) {
        for (Iterator<Integer> it = t.iterator(); it.hasNext();) {
            System.out.print(it.next() + ", ");
        }
    }

    public boolean buscar(TreeSet<Integer> t, int buscado) {
        boolean bandera;
        bandera = t.contains(buscado);
        return bandera;
    }

    public void eliminar(TreeSet<Integer> t, int eliminado) {
        t.remove(eliminado);
    }
}
