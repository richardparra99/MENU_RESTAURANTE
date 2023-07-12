import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ventanaEntrada extends JPanel implements ActionListener {
    private Ventana ventana;
    private JLabel lbentradas = new JLabel();
    private JTextField txtSopa = new JTextField();
    private JTextField txtEnsalada = new JTextField();
    private JTextField txtRollos = new JTextField();
    private JTextField txtPapitas = new JTextField();
    private JButton btnRegresar = new JButton("Regresar al menu");
    private int totalEntrada = 0;

    ArrayList<Producto> listaPedidos;
    ArrayList<FacturaVenta> listaPedido;
    Usuario usuario;
    public ventanaEntrada(Ventana v, ArrayList<Producto> listaPedidos, Usuario usuario, ArrayList<FacturaVenta> listaPedido) {
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
        lbentradas.setText("<html><body>1. SOPA DE MANI...............................15bs<br/><br/>" +
                "2. ENSALADAS...................................15bs<br/><br/>" +
                "3. ROLLOS PRIMAVERAS...................8bs<br/><br/>" +
                "4. PAPAS FRITAS...............................12bs</body></html>");
        lbentradas.setBounds(20,20,320,160);
        btnRegresar.setBounds(100, 350, 150, 30);

        txtSopa.setBounds(300,40,120,24);

        txtEnsalada.setBounds(300,75,120,24);

        txtRollos.setBounds(300,105,120,24);

        txtPapitas.setBounds(300,145,120,24);

        this.add(lbentradas);
        this.add(btnRegresar);
        this.add(txtSopa);
        this.add(txtEnsalada);
        this.add(txtRollos);
        this.add(txtPapitas);

        btnRegresar.addActionListener(this);
    }
    public void calcularProducto() {
        if(txtSopa.getText().isEmpty()) {
            txtSopa.setText("0");
        }
        if(txtEnsalada.getText().isEmpty()) {
            txtEnsalada.setText("0");
        }
        if(txtRollos.getText().isEmpty()) {
            txtRollos.setText("0");
        }
        if(txtPapitas.getText().isEmpty()) {
            txtPapitas.setText("0");
        }
        int sopa = Integer.parseInt(txtSopa.getText());
        int ensalada = Integer.parseInt(txtEnsalada.getText());
        int rollos = Integer.parseInt(txtRollos.getText());
        int papitas = Integer.parseInt(txtPapitas.getText());
        getProducto("SOPA DE MANI", sopa);
        getProducto("ENSALADAS", ensalada);
        getProducto("ROLLOS PRIMAVERAS", rollos);
        getProducto("PAPAS FRITAS", papitas);


    }
    public void getProducto(String nombre, int cantidad) {
        for (int i = 0; i < listaPedidos.size(); i++) {
            if (listaPedidos.get(i).getNombre().equals(nombre)) {
                listaPedidos.get(i).setCantidad(cantidad);
                break;
            }
        }
    }
    private void cargarListeners(){
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularProducto();
                Panel2 panel2 = new Panel2(ventana, listaPedidos, usuario, listaPedido);
                añadirPanel2(panel2);
                quitarPanel();
            }
        });
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
