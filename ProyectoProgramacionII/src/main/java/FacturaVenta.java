import java.sql.Date;

public class FacturaVenta {
    private int nroPedido;
    private String metodoPago;
    private Date fecha;
    private int id_Cliente;

    public FacturaVenta(int nroPedido, String metodoPago, Date fecha, int id_Cliente) {
        this.nroPedido = nroPedido;
        this.metodoPago = metodoPago;
        this.fecha = fecha;
        this.id_Cliente = id_Cliente;
    }

    public int getNroPedido() {
        return nroPedido;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setNroPedido(int nroPedido) {
        this.nroPedido = nroPedido;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }
}
