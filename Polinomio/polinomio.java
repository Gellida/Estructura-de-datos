public class polinomio {
    private int coefi, expo;

    public polinomio(int coef) {
        coefi = coef;
    }

    public polinomio(int coef, int exp) {
        coefi = coef;
        expo = exp;
    }

    public int getCoefi() {
        return coefi;
    }

    public int getExpo() {
        return expo;
    }

}
