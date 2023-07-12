import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ventanaPostres extends JPanel implements ActionListener{
    private Ventana ventana;
    private JLabel lbPostres = new JLabel();

    private JTextField txtHelado = new JTextField();
    private JTextField txtFlan = new JTextField();
    private JButton btnRegresar = new JButton("Regresar al menu");
    private int totalPostres = 0;

    ArrayList<Producto> listaPedidos;
    ArrayList<FacturaVenta> listaPedido;
    Usuario usuario;
    public ventanaPostres(Ventana v, ArrayList<Producto> listaPedidos, Usuario usuario, ArrayList<FacturaVenta> listaPedido) {
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
        lbPostres.setText("<html><body>1. Helado....................8Bs<br/><br/>" +
                "2. Flan.........................10Bs</body></html>");
        lbPostres.setBounds(20,50,400,60);

        btnRegresar.setBounds(100, 150, 150, 30);
        // helado
        txtHelado.setBounds(180,50,50,24);
        // flan
        txtFlan.setBounds(180,80,50,24);

        this.add(lbPostres);
        this.add(btnRegresar);
        this.add(txtHelado);
        this.add(txtFlan);

        btnRegresar.addActionListener(this);
    }
    //boton independiente
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
        if(txtHelado.getText().isEmpty()) {
            txtHelado.setText("0");
        }
        if(txtFlan.getText().isEmpty()) {
            txtFlan.setText("0");
        }
        int helado = Integer.parseInt(txtHelado.getText());
        int flan = Integer.parseInt(txtFlan.getText());
        getProducto("Helado", helado);
        getProducto("Flan", flan);
    }
    public void getProducto(String nombre, int cantidad) {
        for (int i = 0; i < listaPedidos.size(); i++) {
            if (listaPedidos.get(i).getNombre().equals(nombre)) {
                listaPedidos.get(i).setCantidad(cantidad);
                break;
            }
        }
    }
    //imagen de fondo
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

    //get de los
    public JTextField getTxtHelado() {
        return txtHelado;
    }

    public JTextField getTxtFlan() {
        return txtFlan;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
