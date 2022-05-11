public class Producto {
    private String codigo;
    private String software;
    private int cantidad;
    private int precio;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSoftwarre() {
        return software;
    }

    public void setSoftwarre(String software) {
        this.software = software;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    Producto(String codigo, String software, int cantidad, int precio) {
        this.codigo = codigo;
        this.software = software;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    Producto() {

    }

    public int compareTo(Producto producto) {
        int resultado = this.codigo.compareTo(producto.codigo);

        if (resultado == 0) {
            resultado = this.software.compareTo(producto.software);
            if (resultado == 0) {
                if (this.precio == producto.precio) {
                    return 0;
                }
                if (this.precio > producto.precio) {
                    return 1;
                } else {
                    return -1;
                }

            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        return this.codigo + " " + this.software + " " + this.cantidad + " " + this.precio;
    }

}
