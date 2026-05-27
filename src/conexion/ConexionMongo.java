package conexion;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConexionMongo {
    public static MongoDatabase getDatabase() {
        try {
            // Se conecta al servidor local de MongoDB y usa la base de datos de la farmacia
            return MongoClients.create("mongodb://localhost:27017").getDatabase("logs_farmacia");
        } catch (Exception e) {
            System.out.println("Error MongoDB: " + e.getMessage());
            return null;
        }
    }
}
