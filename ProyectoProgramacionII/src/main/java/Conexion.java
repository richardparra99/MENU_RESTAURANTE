import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private String host = "localhost"; //127.0.0.1
    private String port = "5432";
    private String database = "Restaurante";
    private String username = "postgres";
    private String password = "root";
    private String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
    private static Conexion conexion;
    private Connection conn;

    public Conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
            JOptionPane.showMessageDialog(null,"Conexion postgreSQL-Java exitosa","Conexion",JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException | SQLException e) {

            JOptionPane.showMessageDialog(null,"Sin Conexion ","Conexion"+e, JOptionPane.ERROR_MESSAGE);
        }
    }
    public Connection getConnection() {
        return conn;
    }

    public static Conexion getInstance(){
        if (conexion == null){
            conexion = new Conexion();
        }
        return conexion;
    }


    public void ejecutarSQL(String sql) {
        try {
            Statement st= conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void desconectar(){
        try {
            conn.close();
            JOptionPane.showMessageDialog(null,"SE HA DESCONECTADO LA CONEXION CON EXITO!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
