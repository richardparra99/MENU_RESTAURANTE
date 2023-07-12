public class Usuario {
    private String nombre;
    private String nit;
    private String direccion;
    private String Email;

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return Email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}
