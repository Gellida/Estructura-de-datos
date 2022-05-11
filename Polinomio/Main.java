import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static LinkedList<polinomio> listaPoli = new LinkedList<>();
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int coefi;
        int expo, valorX;

        System.out.println("Ingrese el valor del primer coeficiente");
        System.out.println("coeficiente");
        coefi = entrada.nextInt();
        System.out.println("exponente");
        expo = entrada.nextInt();

        listaPoli.addLast(new polinomio(coefi, expo));

        System.out.println("Ingrese el valor del Segundo coeficiente");
        System.out.println("coeficiente");
        coefi = entrada.nextInt();
        System.out.println("exponente");
        expo = entrada.nextInt();

        listaPoli.addLast(new polinomio(coefi, expo));

        System.out.println("Ingrese el valor del Tercer coeficiente");
        System.out.println("coeficiente");
        coefi = entrada.nextInt();

        listaPoli.addLast(new polinomio(coefi));

        System.out.println("ingrese el valor para X para sutituir en el polinomio");
        valorX = entrada.nextInt();

        int valor, valor2, valor3;
        double elevacion, eleva1;
        double primerR, segundoR, tercerR, vafinal;

        valor = listaPoli.get(0).getExpo();
        elevacion = Math.pow(valorX, valor);

        primerR = listaPoli.get(0).getCoefi() * elevacion;

        valor2 = listaPoli.get(1).getExpo();
        eleva1 = Math.pow(valorX, valor2);
        segundoR = listaPoli.get(1).getCoefi() * eleva1;

        valor3 = listaPoli.get(2).getCoefi();
        tercerR = valorX * valor3;

        vafinal = primerR + segundoR + tercerR;

        System.out.println("");
        System.out.println("Principal: " + primerR);
        System.out.println("Segundo: " + segundoR);
        System.out.println("TercerR: " + tercerR);
        System.out.println("Termino independiente: " + valorX);
        System.out.println("Resultado del polinomio es: " + (vafinal - valorX));

    }

}
