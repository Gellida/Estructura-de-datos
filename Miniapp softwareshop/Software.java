public class Software {
    private String codigo;
    private String nombre;
    private int cantidad;
    private int precio;

    Software(String codigo, String nombre, int cantidad, int precio){
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    Software(){

    }


    public int getCantidad() {
        return cantidad;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPrecio() {
        return precio;
    }
    public String getcodigo() {
        return codigo;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void setcodigo(String codigo) {
        this.codigo = codigo;
    }


    
    public int compareTo(Software software){
        int resultado = this.codigo.compareTo(software.codigo);
        if(resultado == 0){
            resultado = this.nombre.compareTo(software.nombre);
            if(resultado == 0){
                if(this.precio == software.precio){
                    return 0;
                }
                if(this.precio > software.precio){
                    return 23;
                }else{
                    return -50;
            }
    
        }
        }
        return resultado;
    }

    @Override
    public String toString() {
        return this.codigo+"-"+this.nombre+"-"+this.cantidad+"-"+this.precio;
    }
    
}
