import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Facturacion extends JFrame{

    private double total = 0;
    private String nitCuenta  = "";
    private String nombre  = "";
    private JLabel titulo = new JLabel("*** RESTAURANTE DE 10 ***", SwingConstants.CENTER);
    private JLabel subtitulo = new JLabel("********** FACTURA **********", SwingConstants.CENTER);
    private JLabel original = new JLabel("*********** ORIGINAL **********", SwingConstants.CENTER);
    private JLabel separacion = new JLabel("----------------------------------------------------", SwingConstants.CENTER);
    private JLabel senor = new JLabel("Señor/a: ", SwingConstants.CENTER);
    private JLabel nit = new JLabel("Nit: ", SwingConstants.CENTER);
    private JLabel separacion1 = new JLabel("----------------------------------------------------", SwingConstants.CENTER);
    private JLabel nFactura = new JLabel("Factura N° 4001");
    private JLabel nAutorizacion = new JLabel("Autorizacion N° 385401200130112");
    private JLabel lbfecha = new JLabel("Fecha: 06/09/1999");
    private JLabel ciudad = new JLabel("Santa Cruz - Bolivia", SwingConstants.CENTER);
    private JLabel detalle = new JLabel("DETALLE");
    private JLabel cantidad = new JLabel("CANTIDAD");
    private JLabel subTotal = new JLabel("SUBTOTAL");
    private JLabel separacion2 = new JLabel("--------------------------------------------------------------", SwingConstants.CENTER);
    private JLabel lbTotal = new JLabel("total:", SwingConstants.RIGHT);
    //private JLabel confirmar = new JLabel("Confirmar");
    private ArrayList<Producto> listaPedidos;
    private ArrayList<FacturaVenta> listaPedido;
    private Conexion cone;


    public Facturacion(Usuario usuario, ArrayList<Producto> listaPedidos, ArrayList<FacturaVenta> listaP){
        this.listaPedido = listaP;
        this.listaPedidos = listaPedidos;
        this.setTitle("");
        this.nitCuenta = usuario.getNit();
        this.nombre = usuario.getNombre();
        this.setSize(300,700);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        cone = new Conexion();
        iniciarComponentes();
        this.setVisible(true);
    }
    public void iniciarComponentes(){
        setLayout(null);

        agregarPedido(listaPedido);
        System.out.println(this.nitCuenta+" el nit es");
        System.out.println(this.nombre+" el nombre");

        titulo.setBounds(40,10,200,30);
        subtitulo.setBounds(40,30,200,30);
        separacion.setBounds(20,40,250,30);
        senor.setBounds(20,60,200,30);
        senor.setText(senor.getText()+" "+nombre);
        nit.setBounds(32,80,200,30);
        nit.setText(nit.getText()+" "+ nitCuenta);
        separacion1.setBounds(20,90,250,30);
        nFactura.setBounds(100,110,250,30);
        nAutorizacion.setBounds(50,130,250,30);
        ciudad.setBounds(70,170,150,30);
        lbfecha.setBounds(95,150,150,30);
        detalle.setBounds(20,190,150,30);
        cantidad.setBounds(110,190,150,30);
        subTotal.setBounds(200,190,150,30);
        separacion2.setBounds(15,200,250,30);


        int y = 220;
        for (int i = 0; i < listaPedidos.size(); i++) {
            Producto aux = listaPedidos.get(i);
            if(aux.getCantidad() > 0) {


                aux.setTotal(aux.getCantidad()*aux.getPrecio());

                JLabel cantidad = new JLabel(String.valueOf(aux.getCantidad()));
                JLabel producto = new JLabel(aux.getNombre());
                JLabel sub = new JLabel(String.valueOf(aux.getTotal()));

                total += aux.getTotal();

                cantidad.setBounds(135,y,40,20);
                producto.setBounds(15,y,190,20);
                sub.setBounds(230,y,60,20);
                y+=15;
                this.add(cantidad);
                this.add(producto);
                this.add(sub);
            }
        }

        JLabel totalFactura = new JLabel("" + total);
        y+=15;
        totalFactura.setBounds(230,y,200,20);


        this.add(titulo);
        this.add(subtitulo);
        this.add(separacion);
        this.add(senor);
        this.add(nit);
        this.add(separacion1);
        this.add(nFactura);
        this.add(nAutorizacion);
        this.add(ciudad);
        this.add(lbfecha);
        this.add(detalle);
        this.add(cantidad);
        this.add(subTotal);
        this.add(separacion2);
        this.add(totalFactura);

    }
    public void agregarPedido(ArrayList<FacturaVenta> listaPedido) {
        String sql = "INSERT INTO Producto (Nro_pedido, metodo_pago, fecha, id_cliente) VALUES (?, ?, ?, ?)";

        try (Connection connection = cone.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (FacturaVenta facturaVenta : listaPedido) {
                if (facturaVenta != null && facturaVenta.getNroPedido() > 0) {
                    statement.setInt(1, facturaVenta.getNroPedido());
                    statement.setString(2, facturaVenta.getMetodoPago());
                    statement.setDate(3, facturaVenta.getFecha());
                    statement.setInt(4, facturaVenta.getId_Cliente());

                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
