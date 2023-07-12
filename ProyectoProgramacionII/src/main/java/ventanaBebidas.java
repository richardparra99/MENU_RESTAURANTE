import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ventanaBebidas extends JPanel implements ActionListener{
    private Ventana ventana;
    private JLabel lbBebidas = new JLabel();
    private JTextField txtCoca = new JTextField();
    private JTextField txtRefresco = new JTextField();
    private JTextField txtSprite = new JTextField();
    private JTextField txtFanta = new JTextField();
    private JTextField txtPepsi = new JTextField();
    private JTextField txtCerveza = new JTextField();
    private JTextField txtVino = new JTextField();
    private JButton btnRegresar = new JButton("Regresar al menu");
    private int totalBebidas = 0;

    ArrayList<Producto> listaPedidos;
    ArrayList<FacturaVenta> listaPedido;
    Usuario usuario;
    public ventanaBebidas(Ventana v, ArrayList<Producto> listaPedidos, Usuario usuario, ArrayList<FacturaVenta> listaPedido) {
        this.usuario = usuario;
        this.listaPedidos = listaPedidos;
        this.listaPedido = listaPedido;
        this.ventana = v;
        this.listaPedidos = listaPedidos;
        this.setLayout(null);
        iniciarComponentes();
        cargarListeners();
        this.setVisible(true);

    }
    public void iniciarComponentes(){
        setLayout(null);
        lbBebidas.setText("<html><body>1. Coca Cola 2 Litros........................................12Bs<br/><br/>" +
                "2. Refresco Mocochinchi en Jarra...............15Bs<br/><br/>" +
                "3. Sprite de 2 Litros..........................................12Bs<br/><br/>" +
                "4. Fanta de 2 Litros...........................................12Bs<br/><br/>" +
                "5. Pepsi de 3 Litros...........................................15Bs<br/><br/>" +
                "6. Cerveza de 1 Litro.........................................15Bs<br/><br/>" +
                "7. Vino kohlberg 750 ML..................................25Bs</body></html>");
        lbBebidas.setBounds(20,0,350,250);
        btnRegresar.setBounds(100, 350, 150, 30);

        txtCoca.setBounds(300,20,120,24);

        txtRefresco.setBounds(300,50,120,24);

        txtSprite.setBounds(300,80,120,24);

        txtFanta.setBounds(300,110,120,24);

        txtPepsi.setBounds(300,145,120,24);

        txtCerveza.setBounds(300,180,120,24);

        txtVino.setBounds(300,210,120,24);

        this.add(lbBebidas);
        this.add(btnRegresar);
        this.add(txtCoca);
        this.add(txtRefresco);
        this.add(txtSprite);
        this.add(txtFanta);
        this.add(txtPepsi);
        this.add(txtCerveza);
        this.add(txtVino);

        btnRegresar.addActionListener(this);
    }
    private void cargarListeners(){
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(totalBebidas+" El total es");
                calcularProducto();
                Panel2 panel2 = new Panel2(ventana, listaPedidos, usuario, listaPedido);
                añadirPanel2(panel2);
                quitarPanel();
            }
        });
    }
    public void calcularProducto() {
        if(txtCoca.getText().isEmpty()) {
            txtCoca.setText("0");
        }
        if(txtRefresco.getText().isEmpty()) {
            txtRefresco.setText("0");
        }
        if(txtSprite.getText().isEmpty()) {
            txtSprite.setText("0");
        }
        if(txtFanta.getText().isEmpty()) {
            txtFanta.setText("0");
        }
        if(txtPepsi.getText().isEmpty()) {
            txtPepsi.setText("0");
        }
        if(txtCerveza.getText().isEmpty()) {
            txtCerveza.setText("0");
        }
        if(txtVino.getText().isEmpty()) {
            txtVino.setText("0");
        }
        int coca = Integer.parseInt(txtCoca.getText());
        int refresco = Integer.parseInt(txtRefresco.getText());
        int sprint = Integer.parseInt(txtSprite.getText());
        int fanta = Integer.parseInt(txtFanta.getText());
        int pepsi = Integer.parseInt(txtPepsi.getText());
        int cerveza = Integer.parseInt(txtCerveza.getText());
        int vino = Integer.parseInt(txtVino.getText());

        getProducto("Coca Cola 2 Litros", coca);
        getProducto("Refresco Mocochinchi en Jarra", refresco);
        getProducto("Sprite de 2 Litros", sprint);
        getProducto("Fanta de 2 Litros", fanta);
        getProducto("Pepsi de 3 Litros", pepsi);
        getProducto("Cerveza de 1 Litro", cerveza);
        getProducto("Vino kohlberg 750 ML", vino);


    }
    public void getProducto(String nombre, int cantidad) {
        for (int i = 0; i < listaPedidos.size(); i++) {
            if (listaPedidos.get(i).getNombre().equals(nombre)) {
                listaPedidos.get(i).setCantidad(cantidad);
                break;
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon("Imagenes/fondo color crudo.jpg");
        g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
    }

    public void añadirPanel2(Panel2 panel) {
        ventana.getContentPane().add(panel);
        ventana.revalidate();
    }
    private void quitarPanel() {
        this.ventana.getContentPane().remove(this);
        this.ventana.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
