import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ventanaPlatosFuertes extends JPanel implements ActionListener{
    private Ventana ventana;
    private JLabel lbPlatos = new JLabel();
    private JTextField txtSilpancho = new JTextField();
    private JTextField txtMatambre = new JTextField();
    private JTextField txtPollo = new JTextField();
    private JTextField txtHamburguesa = new JTextField();
    private JTextField txtPicanha = new JTextField();
    private JTextField txtMilanezaC = new JTextField();
    private JTextField txtMilanezaP = new JTextField();
    private JTextField txtRevueltoC = new JTextField();
    private JTextField txtPique = new JTextField();
    private JButton btnRegresar = new JButton("Regresar al menu");
    private int totalPlatosfuertes = 0;

    ArrayList<Producto> listaPedidos;
    ArrayList<FacturaVenta> listaPedido;
    Usuario usuario;

    public ventanaPlatosFuertes(Ventana v, ArrayList<Producto> listaPedidos, Usuario usuario, ArrayList<FacturaVenta> listaPedido) {
        this.usuario = usuario;
        this.listaPedidos = listaPedidos;
        this.listaPedido = listaPedido;
        this.ventana = v;
        this.setLayout(null);
        iniciarComponentes();
        cargarListeners();
        this.setVisible(true);
    }
    public void iniciarComponentes(){
        setLayout(null);
        lbPlatos.setText("<html><body>1. Silpancho....................................25Bs<br/><br/>" +
                "2. Matambre de Cerdo.................44Bs<br/><br/>" +
                "3. Pollo al Horno............................25Bs<br/><br/>" +
                "4. Hamburguesa Clásica............18Bs<br/><br/>" +
                "5. Picanha......................................79Bs<br/><br/>" +
                "6. Milaneza de Carne...................25Bs<br/><br/>" +
                "7. Milaneza de Pollo.....................25Bs<br/><br/>" +
                "8. Revuelto de Carne...................22Bs<br/><br/>" +
                "9. Pique Macho.............................25Bs</body></html>");
        lbPlatos.setBounds(20,20,380,280);
        btnRegresar.setBounds(100, 350, 150, 30);

        txtSilpancho.setBounds(300,20,120,24);

        txtMatambre.setBounds(300,50,120,24);

        txtPollo.setBounds(300,80,120,24);

        txtHamburguesa.setBounds(300,110,120,24);

        txtPicanha.setBounds(300,145,120,24);

        txtMilanezaC.setBounds(300,180,120,24);

        txtMilanezaP.setBounds(300,210,120,24);

        txtRevueltoC.setBounds(300,245,120,24);

        txtPique.setBounds(300,280,120,24);

        this.add(lbPlatos);
        this.add(btnRegresar);
        this.add(txtSilpancho);
        this.add(txtMatambre);
        this.add(txtPollo);
        this.add(txtHamburguesa);
        this.add(txtPicanha);
        this.add(txtMilanezaC);
        this.add(txtMilanezaP);
        this.add(txtRevueltoC);
        this.add(txtPique);

        btnRegresar.addActionListener(this);
    }
    private void cargarListeners(){
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarCompra();
                Panel2 panel2 = new Panel2(ventana, listaPedidos, usuario, listaPedido);
                añadirPanel2(panel2);
                quitarPanel();
            }
        });
    }
    public void verificarCompra() {
        if(txtSilpancho.getText().isEmpty()) {
            txtSilpancho.setText("0");
        }
        if(txtMatambre.getText().isEmpty()) {
            txtMatambre.setText("0");
        }
        if(txtPollo.getText().isEmpty()) {
            txtPollo.setText("0");
        }
        if(txtHamburguesa.getText().isEmpty()) {
            txtHamburguesa.setText("0");
        }
        if(txtPicanha.getText().isEmpty()) {
            txtPicanha.setText("0");
        }
        if(txtMilanezaC.getText().isEmpty()) {
            txtMilanezaC.setText("0");
        }
        if(txtMilanezaP.getText().isEmpty()) {
            txtMilanezaP.setText("0");
        }
        if(txtRevueltoC.getText().isEmpty()) {
            txtRevueltoC.setText("0");
        }
        if(txtPique.getText().isEmpty()) {
            txtPique.setText("0");
        }
        int silpancho = Integer.parseInt(txtSilpancho.getText());
        int matambre = Integer.parseInt(txtMatambre.getText());
        int pollo = Integer.parseInt(txtPollo.getText());
        int hamburguesa = Integer.parseInt(txtHamburguesa.getText());
        int picanha = Integer.parseInt(txtPicanha.getText());
        int milanezaC = Integer.parseInt(txtMilanezaC.getText());
        int milanezaP = Integer.parseInt(txtMilanezaP.getText());
        int revueltoC = Integer.parseInt(txtRevueltoC.getText());
        int pique = Integer.parseInt(txtPique.getText());
        getProducto("Silpancho", silpancho);
        getProducto("Matambre de Cerdo", matambre);
        getProducto("Pollo al Horno", pollo);
        getProducto("Hamburguesa Clásica", hamburguesa);
        getProducto("Picanha", picanha);
        getProducto("Milaneza de Carne", milanezaC);
        getProducto("Milaneza de Pollo", milanezaP);
        getProducto("Revuelto de Carne", revueltoC);
        getProducto("Pique Macho", pique);
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
