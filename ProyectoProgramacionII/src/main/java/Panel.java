import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener{
    private JLabel lbetiqueta = new JLabel();
    private JLabel lbNombre = new JLabel("Nombre:");
    private JLabel lbNit = new JLabel("Nit:");
    private JLabel lbDireccion = new JLabel("Direccion");
    private JLabel lbEmail = new JLabel("Email");
    private JLabel lbFondo;
    private Ventana ventana;
    private JTextField txtNombre = new JTextField();
    private JTextField txtNit = new JTextField();
    private JTextField txtDireccion = new JTextField();
    private JTextField txtEmail = new JTextField();
    private String nitCuenta  = "";
    private Conexion conex = new Conexion();

    private JButton btnRegitrar = new JButton("Registrar");


    public Panel(Ventana v) {
        this.ventana = v;
        this.setLayout(null);
        init();
        this.setVisible(true);
    }
    public Panel(){

    }

    public void init() {
        lbFondo = new JLabel();
        lbFondo.setBounds(0, 0, 1000, 550);
        lbetiqueta.setText(" BIENVENIDOS A RESTAURANTE");
        lbetiqueta.setBounds(110, 85, 800, 80);
        lbetiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        lbetiqueta.setForeground(Color.WHITE);
        lbetiqueta.setFont(new Font("cooper black", Font.PLAIN, 40));
        // color a lb
        lbNombre.setOpaque(true);
        lbNombre.setBackground(Color.WHITE);
        lbNit.setOpaque(true);
        lbNit.setBackground(Color.WHITE);


        int x = 385;
        int y = 285;

        lbNombre.setBounds(x, y, 100, 24);
        txtNombre.setBounds(x + 70, y, 130, 24);
        y += 35;
        lbNit.setBounds(x, y, 100, 24);
        txtNit.setBounds(x + 70, y, 130, 24);
        y += 80;
        btnRegitrar.setBounds(x + 70, y, 130, 24);
        cargarListeners();

        this.add(lbetiqueta);
        this.add(lbNombre);
        this.add(lbNit);
        this.add(txtNombre);
        this.add(txtNit);
        this.add(btnRegitrar);
        this.add(lbFondo);
    }

    private void cargarListeners() {
        btnRegitrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.quitarPanelMenu();
                String nombre = txtNombre.getText();
                nitCuenta = txtNit.getText();
                Usuario usuario = new Usuario();
                usuario.setNit(nitCuenta);
                usuario.setNombre(nombre);
                crearCliente(usuario);
                Panel2 panel2 = new Panel2(ventana, usuario);
                añadirPanel2(panel2);
                quitarPanel();
            }
        });
    }
    public void crearCliente(Usuario usuario) {
        String sql = "INSERT INTO Cliente (Nombre, Nit, Direccion, Email) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = conex.getConnection().prepareStatement(sql);
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getNit());
            statement.setString(3, usuario.getDireccion());
            statement.setString(4, usuario.getEmail());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 550);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon("Imagenes/thumb-1920-438979.jpg");
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
    public boolean verificador(String nombre, String nit) {
        boolean verificado = true;
        return verificado;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       /* if (e.getSource() == btnRegitrar){
            this.veri = verificador(txtNombre.getText(),txtNit.getText());
            txtNombre.setText("");
            txtNit.setText("");
            JOptionPane.showMessageDialog(null,"registre datos porfavor");
        }*/
    }
}
