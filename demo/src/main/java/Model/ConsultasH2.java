package demo.src.main.java.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import demo.src.main.java.Database.Conexion;
public class ConsultasH2 {
    
    public void insertarMedicamento(Medicaments medicamento) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO medicamentos (nombre) VALUES (?)")) {

            preparedStatement.setString(1, medicamento.getName());  // Corregido a getName()

            preparedStatement.executeUpdate();

            System.out.println("Medicamento insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        Conexion conexion = new Conexion();
        return conexion.getConexion();
    }
}