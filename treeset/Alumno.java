public class Alumno {

    private String matricula;
    private String calificacion;

    Alumno(String matricula, String calificacion) {

        this.matricula = matricula;
        this.calificacion = calificacion;
    }

    Alumno() {

    }

    public String getMatricula() {
        return matricula;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    /*
     * public int compareTo(Alumno alumno){ int resultado =
     * this.matricula.compareTo(alumno.matricula); if(resultado == 0){ resultado =
     * this.calificacion.compareTo(alumno.calificacion); if(resultado == 0){
     * if(this.calificacion == alumno.calificacion){ return 0; }
     * if(this.calificacion > alumno.calificacion){ return 23; }else{ return -50; }
     * 
     * } } return resultado; }
     */
    @Override
    public String toString() {
        return this.matricula + "-" + this.calificacion;
    }

}
