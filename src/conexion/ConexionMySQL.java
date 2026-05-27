package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_farmacia";
    private static final String USER = "root";
    private static final String PASSWORD = "tu_password";

    public static Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Error MySQL: " + e.getMessage());
            return null;
        }
    }
}
