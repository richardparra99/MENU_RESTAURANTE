import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//no registra los productos, ni la facturaventa
public class Panel2 extends JPanel implements ActionListener {
    private Ventana ventana;
    private JButton btnEntrada = new JButton("COMPLEMENTO");
    private JButton btnPlatos = new JButton("COMIDA RAPIDA");
    private JButton btnBebidas = new JButton("BEBIDAS");
    private JButton btnPostres = new JButton("POSTRES");
    private JButton btnCancelar = new JButton("factura");
    //private JButton btnCliente = new JButton("Cliente");
    private JButton btnSalir = new JButton("SALIR");
    private BufferedImage imagen;
    private String nitCuenta  = "";
    //string
    private String nombre ="";
    private ArrayList<Producto> listaPedidos = new ArrayList<>();
    private ArrayList<FacturaVenta> listaPedido = new ArrayList<>();
    private Usuario usuario;

    public Panel2(Ventana v, Usuario usuario) {
        this.ventana = v;
        this.usuario = usuario;
        this.setLayout(null);
        initComponent();
        cargarListeners();
        this.setVisible(true);
        if(listaPedidos.size()==0) {
            this.rellenarMatriz();
        }
        if (listaPedido.size() == 0) {
            this.rellenarMatriz();
        }
    }
    public Panel2(Ventana v, ArrayList<Producto> listaPedidos, Usuario usuario, ArrayList<FacturaVenta> listaPedido) {
        this.ventana = v;
        this.usuario = usuario;
        this.setLayout(null);
        initComponent();
        cargarListeners();
        this.setVisible(true);
        this.ventana = v;
        this.listaPedidos = listaPedidos;
        this.listaPedido = listaPedido;
    }
    public void rellenarMatriz(){
        /*Bebidas*/
        this.listaPedidos.add(new Producto(1,"Coca Cola 2 Litros", 12, 0));
        this.listaPedidos.add(new Producto(2,"Refresco Mocochinchi en Jarra", 15, 0));
        this.listaPedidos.add(new Producto(3,"Sprite de 2 Litros", 12, 0));
        this.listaPedidos.add(new Producto(4,"Fanta de 2 Litros", 12, 0));
        this.listaPedidos.add(new Producto(5,"Pepsi de 3 Litros", 15, 0));
        this.listaPedidos.add(new Producto(6,"Cerveza de 1 Litro", 15, 0));
        this.listaPedidos.add(new Producto(7,"Vino kohlberg 750 ML", 25, 0));
        /*Entradas*/
        this.listaPedidos.add(new Producto(8,"SOPA DE MANI", 15, 0));
        this.listaPedidos.add(new Producto(9,"ENSALADAS", 15, 0));
        this.listaPedidos.add(new Producto(10,"ROLLOS PRIMAVERAS", 8, 0));
        this.listaPedidos.add(new Producto(11,"PAPAS FRITAS", 12, 0));
        /*Platos Fuertes*/
        this.listaPedidos.add(new Producto(12,"Silpancho", 25, 0));
        this.listaPedidos.add(new Producto(13,"Matambre de Cerdo", 44, 0));
        this.listaPedidos.add(new Producto(14,"Pollo al Horno", 25, 0));
        this.listaPedidos.add(new Producto(15,"Hamburguesa Clásica", 18, 0));
        this.listaPedidos.add(new Producto(16,"Picanha", 79, 0));
        this.listaPedidos.add(new Producto(17,"Milaneza de Carne", 25, 0));
        this.listaPedidos.add(new Producto(18,"Milaneza de Pollo", 25, 0));
        this.listaPedidos.add(new Producto(19,"Revuelto de Carne", 22, 0));
        this.listaPedidos.add(new Producto(20,"Pique Macho", 25, 0));
        /*Postres*/
        this.listaPedidos.add(new Producto(21,"Helado", 8, 0));
        this.listaPedidos.add(new Producto(22,"Flan", 10, 0));
    }

    public void initComponent() {
        setLayout(null);

        btnEntrada.setBounds(50, 80, 200, 200);
        btnPlatos.setBounds(250, 300, 200, 200);
        btnBebidas.setBounds(550, 300, 200, 200);
        btnPostres.setBounds(750, 80, 200, 200);
        btnCancelar.setBounds(20, 450, 100, 50);
        //btnCliente.setBounds(300, 450, 100, 50);
        btnSalir.setBounds(20, 20, 100, 50);

        this.add(btnEntrada);
        this.add(btnPlatos);
        this.add(btnBebidas);
        this.add(btnPostres);
        this.add(btnCancelar);
        //this.add(btnCliente);
        this.add(btnSalir);

        btnEntrada.addActionListener(this);
        btnPlatos.addActionListener(this);
        btnBebidas.addActionListener(this);
        btnPostres.addActionListener(this);
        btnCancelar.addActionListener(this);
        //btnCliente.addActionListener(this);
        btnSalir.addActionListener(this);

        try {
            imagen = ImageIO.read(new File("Imagenes/Imagen button.png"));
            btnSalir.setIcon(new ImageIcon(imagen.getScaledInstance(btnSalir.getWidth(), btnSalir.getHeight(),0)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            imagen = ImageIO.read(new File("Imagenes/icono entradas restaurante.png"));
            btnEntrada.setIcon(new ImageIcon(imagen.getScaledInstance(btnEntrada.getWidth(), btnEntrada.getHeight(),0)));
        } catch (IOException e){
            e.printStackTrace();
        }
        try {
            imagen = ImageIO.read(new File("Imagenes/icono platos fuertes.png"));
            btnPlatos.setIcon(new ImageIcon(imagen.getScaledInstance(btnPlatos.getWidth(), btnPlatos.getHeight(),0)));
        } catch (IOException e){
            e.printStackTrace();
        }
        try {
            imagen = ImageIO.read(new File("Imagenes/icono bebidas restaurante.png"));
            btnBebidas.setIcon(new ImageIcon(imagen.getScaledInstance(btnBebidas.getWidth(), btnBebidas.getHeight(),0)));
        } catch (IOException e){
            e.printStackTrace();
        }
        try {
            imagen = ImageIO.read(new File("Imagenes/icono postres restaurante.png"));
            btnPostres.setIcon(new ImageIcon(imagen.getScaledInstance(btnPostres.getWidth(), btnPostres.getHeight(),0)));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void cargarListeners() {
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel panel1 = new Panel(ventana);
                añadirPanel1(panel1);
                quitarPanel();
            }
        });
        btnEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaEntrada ventanaEntrada = new ventanaEntrada(ventana, listaPedidos, usuario, listaPedido);
                añadirVentanaEntrada(ventanaEntrada);
                quitarPanel();
            }
        });
        btnPlatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPlatosFuertes ventanaPlatosFuertes = new ventanaPlatosFuertes(ventana, listaPedidos, usuario, listaPedido);
                añadirVentanaPlatosFuertes(ventanaPlatosFuertes);
                quitarPanel();
            }
        });
        btnBebidas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaBebidas ventanaBebidas = new ventanaBebidas(ventana, listaPedidos, usuario, listaPedido);
                añadirVentanaBebidas(ventanaBebidas);
                quitarPanel();
            }
        });
        btnPostres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPostres ventanaPostres = new ventanaPostres(ventana, listaPedidos, usuario, listaPedido);
                añadirVentanaPostres(ventanaPostres);
                quitarPanel();
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 550);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon("Imagenes/fondo color crudo.jpg");
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
    }

    private void quitarPanel() {
        this.ventana.getContentPane().remove(this);
        this.ventana.revalidate();
    }
    public void añadirPanel2(Panel2 panel2) {
        ventana.getContentPane().add(panel2);
        ventana.revalidate();
    }
    public void añadirPanel1(Panel panel) {
        ventana.getContentPane().add(panel);
        ventana.revalidate();
    }
    public void añadirVentanaEntrada(ventanaEntrada panel){
        ventana.getContentPane().add(panel);
        ventana.revalidate();
    }
    public void añadirVentanaPlatosFuertes(ventanaPlatosFuertes panel){
        ventana.getContentPane().add(panel);
        ventana.revalidate();
    }
    public void añadirVentanaBebidas(ventanaBebidas panel){
        ventana.getContentPane().add(panel);
        ventana.revalidate();
    }
    public void añadirVentanaPostres(ventanaPostres panel){
        ventana.getContentPane().add(panel);
        ventana.revalidate();
    }

    public String getNitCuenta() {
        return nitCuenta;
    }

    public void setNitCuenta(String nitCuenta) {
        this.nitCuenta = nitCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancelar){
            Facturacion factura = new Facturacion(usuario, listaPedidos, listaPedido);
        }
    }
}
