

public class Producto {
    private int id_producto;
    private String nombre;
    private float precio;
    private int cantidad;
    private float total;

    public Producto() {

    }
    public Producto(int id_producto, String nombre, float precio, int cantidad, float total) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
    }

    public Producto(int id_producto, String nombre, float precio, int cantidad){
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = precio * cantidad;
    }

    public int getId_producto() {
        return id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getTotal() {
        return total;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.total = cantidad * precio;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
