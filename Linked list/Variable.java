public class Variable {
    private int coeficiente;
    private int exponente;

    public Variable(int coef, int exp) {
        exponente = exp;
        coeficiente = exp;
    }

    public String resultado() {
        return (coeficiente + ": " + exponente);
    }

    public int getNombre() {
        return coeficiente;
    }

    public void setNombre(int nombre) {
        coeficiente = nombre;
    }

    public int getexponente() {
        return exponente;
    }

    public void setexponente(int exponente) {
        this.exponente = exponente;
    }
}
