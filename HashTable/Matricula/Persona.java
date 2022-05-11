public class Persona {
    private String nombre, cuatrimestre, carrera;
    private int matricula;

    public Persona(String carrera, String nombre, int matricula, String cuatrimestre) {
        this.carrera = carrera;
        this.nombre = nombre;
        this.matricula = matricula;
        this.cuatrimestre = cuatrimestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String toString() {
        return carrera + ", " + nombre + ", " + matricula + ", " + cuatrimestre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getcuatrimestre() {
        return cuatrimestre;
    }

    public void setcuatrimestre(String cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

}