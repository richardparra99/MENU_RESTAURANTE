import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ventana extends JFrame {

    private Panel panel;
    private Panel2 panel2;

    public Ventana(){
        this.setTitle("MENU DE RESTAURANTE DE 10");
        init();
    }

    private void init() {
        panel = new Panel(this);
        añadirPanelMenu();
        this.pack();
        cerrar();
        this.setLocationRelativeTo(null);
    }

    public void añadirPanelMenu() {
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.revalidate();
        repaint();
    }
    public void añadirPanel1(Panel panel) {
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.revalidate();
        repaint();
    }

    public void añadirPanel2() {
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel2, BorderLayout.CENTER);
        this.revalidate();
        repaint();
    }

    public void quitarPanelMenu() {
        this.getContentPane().remove(panel);
        this.revalidate();
    }

    public void quitarPanel2() {
        this.getContentPane().remove(panel2);
        this.revalidate();
    }


    private void cerrar() {
        try {
            this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    confirmarSalida();
                }
            });
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void confirmarSalida() {
        int valor = JOptionPane.showConfirmDialog(this, "¿Esta seguro de cerrar la aplicación?", "Advertencia", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        if (valor == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Gracias por su visita, Hasta pronto", "Gracias", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

}
