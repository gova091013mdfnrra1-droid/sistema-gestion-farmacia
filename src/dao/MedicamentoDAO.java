package dao;

import conexion.ConexionMySQL;
import conexion.ConexionMongo;
import modelo.Medicamento;
import org.bson.Document;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MedicamentoDAO {

    public boolean insertar(Medicamento med) {
        String sql = "INSERT INTO medicamentos (nombre, precio, stock) VALUES (?, ?, ?)";
        try (Connection con = ConexionMySQL.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, med.getNombre());
            ps.setDouble(2, med.getPrecio());
            ps.setInt(3, med.getStock());
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                // Si se guardó en MySQL, generamos de forma híbrida un log automático en MongoDB
                try {
                    ConexionMongo.getDatabase().getCollection("historial_cambios")
                        .insertOne(new Document("accion", "Medicamento Registrado")
                        .append("producto", med.getNombre())
                        .append("precio", med.getPrecio())
                        .append("fecha", new java.util.Date().toString()));
                } catch (Exception e) {
                    System.out.println("Error al escribir log en MongoDB: " + e.getMessage());
                }
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al insertar en MySQL: " + e.getMessage());
        }
        return false;
    }
}
